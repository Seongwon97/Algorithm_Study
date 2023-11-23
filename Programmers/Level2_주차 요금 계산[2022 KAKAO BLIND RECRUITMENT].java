import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	public int[] solution(int[] fees, String[] records) {
		int baseTime = fees[0];
		int baseFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];

		Map<Integer, Integer> totalParkingTimes = new HashMap<>();
		Map<Integer, Time> inOutTime = new HashMap<>();

		for (String r : records) {
			String[] splitRecord = r.split(" ");
			int carNumber = Integer.parseInt(splitRecord[1]);
			Time time = Time.of(splitRecord[0]);

			if (splitRecord[2].equals("IN")) {
				inOutTime.put(carNumber, time);
			} else {
				Time inTime = inOutTime.get(carNumber);
				int fee = inTime.calculateParkingTime(time);

				totalParkingTimes.put(carNumber, totalParkingTimes.getOrDefault(carNumber, 0) + fee);

				inOutTime.remove(carNumber);
			}
		}

		Time endTime = new Time(23, 59);

		for (int carNumber : inOutTime.keySet()) { // 하루가 끝날때까지 출차하지 않은 차들
			Time inTime = inOutTime.get(carNumber);
			int fee = inTime.calculateParkingTime(endTime);

			totalParkingTimes.put(carNumber, totalParkingTimes.getOrDefault(carNumber, 0) + fee);
		}

		List<Integer> carNumbers = totalParkingTimes.keySet()
			.stream()
			.sorted()
			.collect(Collectors.toList());

		int[] answer = new int[carNumbers.size()];
		for (int i = 0; i < carNumbers.size(); i++) {
			answer[i] = calculateParkingFee(totalParkingTimes.get(carNumbers.get(i)), baseTime, baseFee, unitTime, unitFee);
		}

		return answer;
	}

	private int calculateParkingFee(int time, int baseTime, int baseFee, int unitTime, int unitFee) {
		int totalFee = baseFee;

		if (time <= baseTime) {
			return totalFee;
		}

		time -= baseTime;
		int numOfUnitTime = (time / unitTime);
		if (time % unitTime != 0) {
			numOfUnitTime++;
		}
		totalFee += (numOfUnitTime * unitFee);

		return totalFee;
	}

	static class Time {
		int hour;
		int minute;

		public Time(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}

		public static Time of(String record) {
			String[] split = record.split(":");
			int hour = Integer.parseInt(split[0]);
			int minute = Integer.parseInt(split[1]);
			return new Time(hour, minute);
		}

		public int toMinute() {
			return hour * 60 + minute;
		}

		public int calculateParkingTime(Time outTime) {
			return outTime.toMinute() - this.toMinute();
		}
	}
}
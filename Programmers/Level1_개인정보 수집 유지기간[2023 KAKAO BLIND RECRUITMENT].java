import java.util.*;
import java.time.*;

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		Map<Character, Integer> ts = new HashMap<>();
		for (String t : terms) {
			String[] split = t.split(" ");
			ts.put(split[0].charAt(0), Integer.parseInt(split[1]));
		}

		List<Integer> toDestroyIds = new ArrayList<>();
		LocalDate todayDate = parseToDate(today);

		for (int i = 0; i < privacies.length; i++) {
			String[] splitPrivacy = privacies[i].split(" ");
			LocalDate collectedDate = parseToDate(splitPrivacy[0]);
			if (isNeedToDestroy(todayDate, collectedDate, ts.get(splitPrivacy[1].charAt(0)))) {
				toDestroyIds.add(i + 1);
			}
		}

		int[] answer = new int[toDestroyIds.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = toDestroyIds.get(i);
		}

		return answer;
	}

	private LocalDate parseToDate(String date) {
		String[] splitDate = date.split("\\.");
		return LocalDate.of(Integer.parseInt(splitDate[0]), Integer.parseInt(splitDate[1]), Integer.parseInt(splitDate[2]));
	}

	private boolean isNeedToDestroy(LocalDate today, LocalDate collectedDate, int duration) {
		LocalDate changedDate = collectedDate.plusMonths(duration);
		changedDate = changedDate.minusDays(1);

		return today.isAfter(changedDate);
	}
}
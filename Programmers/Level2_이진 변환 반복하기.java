class Solution {
	public int[] solution(String s) {
		int[] answer = new int[2];
		while (!s.equals("1")) {
			int numOfZero = countZero(s);
			int numOfNextS = s.length() - numOfZero;
			s = createBinaryNumber(numOfNextS);

			answer[0]++;
			answer[1] += numOfZero;
		}

		return answer;
	}

	private int countZero(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '0') {
				count++;
			}
		}
		return count;
	}

	private String createBinaryNumber(int number) {
		StringBuilder sb = new StringBuilder();
		while (number > 1) {
			int remain = number % 2;
			number /= 2;
			sb.insert(0, remain);
		}

		sb.insert(0, number);

		return sb.toString();
	}
}
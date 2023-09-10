// https://school.programmers.co.kr/learn/courses/15008/lessons/121683
class Solution {
	public String solution(String input_string) {
		int[] numOfAppears = new int[26];
		char previous = input_string.charAt(0);
		numOfAppears[previous - 'a']++;

		for (int i = 1; i < input_string.length(); i++) {
			char current = input_string.charAt(i);
			if (current == previous) {
				continue;
			}

			previous = current;
			numOfAppears[current - 'a']++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			if (numOfAppears[i] > 1) {
				sb.append((char)(i + 'a'));
			}
		}

		String answer = "N";
		if (sb.length() != 0) {
			answer = sb.toString();
		}

		return answer;
	}
}

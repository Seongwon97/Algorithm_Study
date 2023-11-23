import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public int[] solution(String[] gems) {
		Set<String> uniqueGems = new HashSet<>(Arrays.asList(gems));

		int numOfElementTypes = uniqueGems.size();

		Map<String, Integer> numOfElements = new HashMap<>();
		int[][] dp = new int[2][gems.length]; // 0번 idx는 구간 길이, 1번 idx는 종료 idx정보
		Arrays.fill(dp[0], Integer.MAX_VALUE);

		int firstIdx = 0;

		for (int i = 0; i < gems.length; i++) {
			String g = gems[i];
			numOfElements.put(g, numOfElements.getOrDefault(g, 0) + 1);

			while (numOfElements.keySet().size() == numOfElementTypes) {
				int length = i - firstIdx + 1;
				if (dp[0][firstIdx] > length) {
					dp[0][firstIdx] = length;
					dp[1][firstIdx] = i;
				}

				int numOfFirstElements = numOfElements.get(gems[firstIdx]);
				if (numOfFirstElements <= 1) {
					break;
				}

				numOfElements.put(gems[firstIdx], numOfFirstElements - 1);
				firstIdx++;
			}
		}

		int minLength = Integer.MAX_VALUE;
		int lastIdx = 0;
		for (int i = 0; i < gems.length; i++) {
			if (dp[0][i] < minLength) {
				minLength = dp[0][i];
				lastIdx = dp[1][i];
				firstIdx = i;
			}
		}

		return new int[] {firstIdx + 1, lastIdx + 1};
	}
}
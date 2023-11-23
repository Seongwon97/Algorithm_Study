import java.util.Arrays;

class Solution {
	private static final int INF = 30_000_000;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] minFares = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(minFares[i], INF);
			minFares[i][i] = 0;
		}

		for (int[] fare : fares) {
			minFares[fare[0]][fare[1]] = fare[2];
			minFares[fare[1]][fare[0]] = fare[2];
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					minFares[i][j] = Math.min(minFares[i][j], minFares[i][k] + minFares[k][j]);
				}
			}
		}


		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			answer = Math.min(answer, minFares[s][i] + minFares[i][a] + minFares[i][b]);
		}

		return answer;
	}
}
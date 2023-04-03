class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] hasReserve = new boolean[n + 1];
        for (int r : reserve) {
            hasReserve[r] = true;
        }

        boolean[] isLost = new boolean[n + 1];
        for (int l : lost) {
            isLost[l] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (isLost[i] && hasReserve[i]) {
                isLost[i] = false;
                hasReserve[i] = false;
                answer++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!isLost[i]) {
                continue;
            }

            if (i > 1 && hasReserve[i - 1]) {
                hasReserve[i - 1] = false;
                answer++;
            } else if (i < n && hasReserve[i + 1]) {
                hasReserve[i + 1] = false;
                answer++;
            }
        }

        return answer;
    }
}

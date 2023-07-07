class Solution {
    private static int maxGap = Integer.MIN_VALUE;
    private static int[] answer;

    public int[] solution(int n, int[] info) {
        answer = new int[11];
        dfs(n, 0, info, new int[11]);
        if (maxGap == Integer.MIN_VALUE) {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }

    private void dfs(int remainArrows, int currentIdx, int[] apeach, int[] ryon) {
        if (remainArrows <= 0) {
            int gap = calculateScoreGap(apeach, ryon);
            if (gap > 0) {
                if ((gap == maxGap && hasMoreLowerPoint(answer, ryon)) || gap > maxGap) {
                    maxGap = gap;
                    answer = ryon.clone();
                }
            }
        }

        for (int i = currentIdx; i < 11; i++) {
            if (i == 10) {
                ryon[i] = remainArrows;
                dfs(0, i + 1, apeach, ryon);
                ryon[i] = 0;
            }

            if (apeach[i] < remainArrows) { // 현재 잔여 화살이 현재 어피치가 맞춘 점수의 개수보다 많은 경우
                ryon[i] = apeach[i] + 1;
                dfs(remainArrows - ryon[i], i + 1, apeach, ryon);
                ryon[i] = 0;
            }
        }

        if (currentIdx == 10) {
            ryon[10] = remainArrows;
            dfs(0, currentIdx + 1, apeach, ryon);
        }
    }

    private int calculateScoreGap(int[] apeach, int[] ryon) {
        int gap = 0;
        for (int i = 0; i < 11; i++) {
            if (apeach[i] == 0 && ryon[i] == 0) {
                continue;
            }

            if (apeach[i] >= ryon[i]) { // 어피치가 점수를 획득한 경우
                gap -= (10 - i);
            } else {
                gap += (10 - i);
            }
        }
        return gap;
    }

    private boolean hasMoreLowerPoint(int[] answer, int[] newAnswer) {
        for (int i = 10; i >= 0; i--) {
            if (newAnswer[i] > answer[i]) {
                return true;
            } else if (newAnswer[i] < answer[i]) {
                return false;
            }
        }
        return false;
    }
}

package chapter3_greedy;

// 기둥과 보 설치 (구현)
// https://school.programmers.co.kr/learn/courses/30/lessons/60061
public class Ch12_implementation_Q12 {
    private boolean[][] pillar, wall; // 기둥, 보
    private final int PILLAR = 0;
    private final int WALL = 1;
    private final int REMOVE = 0;
    private final int BUILD = 1;

    public int[][] solution(int n, int[][] build_frame) {
        int count = 0;
        pillar = new boolean[n + 3][n + 3];
        wall = new boolean[n + 3][n + 3];

        for (int[] frame : build_frame) {
            int x = frame[0] + 1;
            int y = frame[1] + 1;
            if (frame[2] == PILLAR) {
                if (frame[3] == BUILD && canBuildPillar(x, y)) {
                    pillar[x][y] = true;
                    count++;
                }
                if (frame[3] == REMOVE && canRemove(x, y, n, PILLAR)) {
                    pillar[x][y] = false;
                    count--;
                }
            } else {
                if (frame[3] == BUILD && canBuildWall(x, y)) {
                    wall[x][y] = true;
                    count++;
                }
                if (frame[3] == REMOVE && canRemove(x, y, n, WALL)) {
                    wall[x][y] = false;
                    count--;
                }
            }
        }

        int[][] answer = new int[count][3];
        int index = 0;
        for (int i = 1; i <= n + 1; i++) { // 남아 있는 기둥과 보 배열에 저장
            for (int j = 1; j <= n + 1; j++) {
                if (pillar[i][j]) {
                    answer[index++] = new int[]{i - 1, j - 1, PILLAR};
                }
                if (wall[i][j]) {
                    answer[index++] = new int[]{i - 1, j - 1, WALL};
                }
            }
        }
        return answer;
    }

    private boolean canBuildPillar(int x, int y) {
        return y == 1 || pillar[x][y - 1] || wall[x][y] || wall[x - 1][y];
    }

    private boolean canBuildWall(int x, int y) {
        return pillar[x][y - 1] || pillar[x + 1][y - 1] || (wall[x - 1][y] && wall[x + 1][y]);
    }

    private boolean canRemove(int x, int y, int n, int type) {
        boolean result = true;

        if (type == PILLAR) {
            pillar[x][y] = false; // 임시 삭제
        } else {
            wall[x][y] = false;
        }

        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (!result) {
                    break;
                }
                if (pillar[i][j] && !canBuildPillar(i, j)) {
                    result = false;
                }
                if (wall[i][j] && !canBuildWall(i, j)) {
                    result = false;
                }
            }
        }

        if (type == PILLAR) {
            pillar[x][y] = true;
        } else {
            wall[x][y] = true;
        }

        return result;
    }
}
/*
입력값 〉	5, [[1, 0, 0, 1], [1, 1, 1, 1], [2, 1, 0, 1], [2, 2, 1, 1], [5, 0, 0, 1], [5, 1, 0, 1], [4, 2, 1, 1], [3, 2, 1, 1]]
기댓값 〉	[[1, 0, 0], [1, 1, 1], [2, 1, 0], [2, 2, 1], [3, 2, 1], [4, 2, 1], [5, 0, 0], [5, 1, 0]]
 */

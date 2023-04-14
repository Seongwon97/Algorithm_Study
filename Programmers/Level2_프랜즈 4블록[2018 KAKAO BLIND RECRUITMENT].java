import java.util.*;

class Solution {
    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1};

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = board[i].toCharArray();
        }

        boolean[][] toRemove = new boolean[m][n];
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '*') {
                        continue;
                    }
                    if (canErease(m, n, i, j, matrix)) {
                        toRemove[i][j] = true;
                        for (int k = 0; k < 3; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            toRemove[nx][ny] = true;
                        }
                    }
                }
            }

            int numOfRemovedBlock = removeBlock(m, n, matrix, toRemove);
            answer += numOfRemovedBlock;
            if (numOfRemovedBlock == 0) {
                flag = false;
            }

            toRemove = new boolean[m][n];
        }

        return answer;
    }

    private boolean canErease(int m, int n, int x, int y, char[][] matrix) {
        char block = matrix[x][y];
        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                return false;
            }

            if (block != matrix[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    private int removeBlock(int m, int n, char[][] matrix, boolean[][] toRemove) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            Queue<Character> remains = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (toRemove[j][i]) {
                    count++;
                    continue;
                }
                remains.add(matrix[j][i]);
            }

            for (int j = m - 1; j >= 0; j--) {
                if (!remains.isEmpty()) {
                    char polled = remains.poll();
                    matrix[j][i] = polled;
                } else {
                    matrix[j][i] = '*';
                }
            }
        }
        return count;
    }
}

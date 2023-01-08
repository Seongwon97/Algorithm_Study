package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 감시 피하기 (DFS)
// https://www.acmicpc.net/problem/18428
public class B18428 {

    private static boolean isPossible = false;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            char[][] matrix = new char[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = st.nextToken()
                            .charAt(0);
                }
            }

            dfs(matrix, 0);
            if (isPossible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(char[][] matrix, int depth) {
        if (depth == 3) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j] == 'S') {
                        if (isDetectedByTeacher(matrix, i, j)) {
                            return;
                        }
                    }
                }
            }
            isPossible = true;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (isPossible) {
                    return;
                }

                if (matrix[i][j] != 'X') {
                    continue;
                }

                matrix[i][j] = 'O';
                dfs(matrix, depth + 1);
                matrix[i][j] = 'X';
            }
        }
    }

    private static boolean isDetectedByTeacher(char[][] matrix, int row, int column) {
        for (int i = row; i < matrix.length; i++) {
            if (matrix[i][column] == 'O') {
                break;
            } else if (matrix[i][column] == 'T') {
                return true;
            }
        }

        for (int i = row; i > 0; i--) {
            if (matrix[i][column] == 'O') {
                break;
            } else if (matrix[i][column] == 'T') {
                return true;
            }
        }

        for (int i = column; i < matrix.length; i++) {
            if (matrix[row][i] == 'O') {
                break;
            } else if (matrix[row][i] == 'T') {
                return true;
            }
        }

        for (int i = column; i > 0; i--) {
            if (matrix[row][i] == 'O') {
                break;
            } else if (matrix[row][i] == 'T') {
                return true;
            }
        }
        return false;
    }
}

/*
Input
2
5 6
0 0 1 0

Output
30
30
---
Input
3
3 4 5
1 0 1 0

Output
35
17
---
Input
6
1 2 3 4 5 6
2 1 1 1

Output
54
-24
 */

package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3109
// 빵집
public class Main {
    private static int R = 0;
    private static int C = 0;
    private static char[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            if (matrix[i][0] == 'x') {
                continue;
            }

            if (dfs(i, 0, visited)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean dfs(int row, int column, boolean[][] visited) {
        if (column == C - 1) {
            return true;
        }

        int[] dx = {-1, 0, 1};
        for (int d : dx) { // 대각선, 옆을 모두 이동하며 가장 처음에 도착하는 곳만 체크하고 break;
            int nextRow = row + d;
            if (nextRow < 0 || nextRow >= R || matrix[nextRow][column + 1] == 'x' || visited[nextRow][column + 1]) {
                continue;
            }

            visited[nextRow][column + 1] = true;
            if (dfs(nextRow, column + 1, visited)) {
                return true;
            }
        }
        return false;
    }
}
/*
Input
5 5
.xx..
..x..
.....
...x.
...x.

Output
2
--------
Input
6 10
..x.......
.....x....
.x....x...
...x...xx.
..........
....x.....

Output
5
--------
Input
15 15
.xxxxxxxxxx....
...x.......xxx.
...x.......x...
..xx.......xx..
...x........xx.
.x.x......x.x..
...x......xx...
.x.x....xxx....
.x....x.x......
.x.....xx.x....
.x..x.xx.......
.....xx........
....x..........
......x........
...............

Output
4
*/

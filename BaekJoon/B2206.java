import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2206
// 벽 부수고 이동하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(String.valueOf(line.charAt(j)));
                if (input == 1) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = input;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int answer = -1;
        boolean[][][] visited = new boolean[N][M][2];
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, true, 1));

        while (!queue.isEmpty()) {
            Position polled = queue.poll();
            if (polled.x == N - 1 && polled.y == M - 1) {
                answer = polled.numOfMoves;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = polled.x + dx[i];
                int ny = polled.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (matrix[nx][ny] == 0) {
                    if (polled.hasChance && !visited[nx][ny][0]) { // 벽을 부순 적이 없을 경우
                        queue.add(new Position(nx, ny, true, polled.numOfMoves + 1));
                        visited[nx][ny][0] = true;
                    } else if (!polled.hasChance && !visited[nx][ny][1]) { // 벽을 부순 적이 있을 경우
                        queue.add(new Position(nx, ny, false, polled.numOfMoves + 1));
                        visited[nx][ny][1] = true;
                    }
                } else if (matrix[nx][ny] == -1) {
                    if (polled.hasChance) {
                        queue.add(new Position(nx, ny, false, polled.numOfMoves + 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static class Position {
        int x;
        int y;
        boolean hasChance;
        int numOfMoves;

        public Position(int x, int y, boolean hasChance, int numOfMoves) {
            this.x = x;
            this.y = y;
            this.hasChance = hasChance;
            this.numOfMoves = numOfMoves;
        }
    }
}
/*
Input
6 4
0100
1110
1000
0000
0111
0000

Output
15

-----
Input
4 4
0111
1111
1111
1110

Output
-1

-----
Input
5 6
000000
101111
001011
011010
000010

Output
12
*/

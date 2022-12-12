package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ch4_implementation_ex4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] leftDirection = {3, 0, 1, 2};
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1;
        int turnTime = 0;
        visited[a][b] = true;
        while (true) {

            d = leftDirection[d];

            int nx = b + dx[d];
            int ny = a + dy[d];
            if (!visited[ny][nx] && matrix[ny][nx] == 0) {
                visited[ny][nx] = true;
                a = ny;
                b = nx;
                answer++;
                turnTime = 0;
                continue;
            }
            turnTime++;

            if (turnTime == 4) {
                nx = b - dx[d];
                ny = a - dy[d];

                if (matrix[ny][nx] == 0) {
                    a = ny;
                    b = nx;
                } else {
                    break;
                }

                turnTime = 0;
            }
        }

        System.out.println(answer);
    }
}

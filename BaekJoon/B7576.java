import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        boolean[][] checked = new boolean[M][N];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    queue.add(i);
                    queue.add(j);
                    checked[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M ||
                        checked[ny][nx] || matrix[ny][nx] != 0) {
                    continue;
                }

                matrix[ny][nx] = matrix[y][x] + 1;
                checked[ny][nx] = true;

                queue.add(ny);
                queue.add(nx);
            }
        }

        int max = -1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    return -1;
                }
                max = Math.max(matrix[i][j], max);
            }
        }

        return max -1;
    }
}

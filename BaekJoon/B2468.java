import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        int maxHeight = -1;


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, matrix[i][j]);
            }
        }

        int maxArea = 0;
        for (int i = 0; i < maxHeight + 1; i++) {
            int result = countArea(i);
            if (result > maxArea) {
                maxArea = result;
            }
        }

        System.out.println(maxArea);
        br.close();
    }

    static int countArea(int height) {
        check = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && matrix[i][j] > height) {
                    count++;
                    bfs(i, j, height);
                }
            }
        }
        return count;
    }

    static void bfs(int currentY, int currentX, int height) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(currentY);
        queue.add(currentX);
        check[currentY][currentX] = true;

        while (!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || check[ny][nx] || matrix[ny][nx] <= height) {
                    continue;
                }
                check[ny][nx] = true;
                queue.add(ny);
                queue.add(nx);
            }
        }
    }
}

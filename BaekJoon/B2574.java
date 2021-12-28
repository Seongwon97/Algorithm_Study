import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] matrix;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (!checkSeparate()) {
            meltForYear();
            result++;
            if (checkAllMelt()) {
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

    // 1년 단위로 높이 축소하는 메서드
    private static void meltForYear() {
        int[][] tempMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] > 0)
                    tempMatrix[i][j] = melt(i, j);
            }
        }
        matrix = tempMatrix;
    }

    // 각각의 칸을 녹이는 메서드
    private static int melt(int y, int x) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || matrix[ny][nx] == 0) {
                count++;
            }
        }
        if (matrix[y][x] >= count) {
            return matrix[y][x] - count;
        }
        return 0;
    }

    // 두 덩이 이상으로 나뉘었는지 체크하는 메서드
    private static boolean checkSeparate() {
        boolean[][] checked = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] > 0 && !checked[i][j]) {
                    dfs(i, j, checked);
                    count++;
                }
                if (count >= 2) return true;
            }
        }
        return false;
    }

    // dfs 탐색 메서드
    private static void dfs(int y, int x, boolean[][] checked) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= M || ny < 0 || ny >= N || matrix[ny][nx] == 0 || checked[ny][nx]) {
                continue;
            }
            checked[ny][nx] = true;
            dfs(ny, nx, checked);
        }
    }

    // 빙산이 모두 녹았는지 체크
    private static boolean checkAllMelt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

package chapter3_greedy;
// 음료수 얼려 먹기
public class Ch5_dfs_bfs_ex1 {

    public static void main(String[] args) {
        int[][] iceTray = {{0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        System.out.println(solution(iceTray));
    }

    private static int solution(int[][] iceTray) {
        int numOfRows = iceTray.length;
        int numOfColumns = iceTray[0].length;
        boolean[][] visited = new boolean[numOfRows][numOfColumns];

        int answer = 0;
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                if (iceTray[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j, iceTray, visited);
                    answer++;
                }
            }
        }
        return answer;
    }

    private static void dfs(int y, int x, int[][] iceTray, boolean[][] visited) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (ny < 0 || ny >= iceTray.length || nx < 0 || nx >= iceTray[0].length) {
                continue;
            }

            if (iceTray[ny][nx] == 0 && !visited[ny][nx]) {
                dfs(ny, nx, iceTray, visited);
            }
        }
    }
}

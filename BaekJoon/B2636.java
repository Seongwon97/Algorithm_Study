import java.io.*;
import java.util.*;

public class Main {
    static class Air {
        int row, col, cnt;

        public Air(int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visit;
    static int R, C, N, ans, cnt;
    static int cheese, time;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) cheese++;
            }
        }
        while (cheese > 0) {
            visit = new boolean[R][C];
            time++;
            cnt = 0;
            for (int j = 0; j < C; j++) {
                if (!visit[0][j] && map[0][j] == 0) {
                    bfs(0, j);
                }
                if (!visit[R - 1][j] && map[R - 1][j] == 0) {
                    bfs(R - 1, j);
                }
            }
            for (int j = 0; j < R; j++) {
                if (!visit[j][0] && map[j][0] == 0) {
                    bfs(j, 0);
                }
                if (!visit[j][C - 1] && map[j][C - 1] == 0) {
                    bfs(j, C - 1);
                }
            }
        }
        System.out.println(time);
        System.out.println(cnt);
    }

    private static void bfs(int row, int col) {
        Queue<Air> q = new LinkedList<>();
        visit[row][col] = true;
        q.add(new Air(row, col, 0));
        while (!q.isEmpty()) {
            Air air = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nx = air.row + dx[dir];
                int ny = air.col + dy[dir];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    cheese--;
                    cnt++;
                    continue;
                } else q.add(new Air(nx, ny, air.cnt + 1));
            }
        }
    }
}
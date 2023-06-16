package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/5427
// 불
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            int cpx = 0; // current position x
            int cpy = 0; // current position y
            char[][] map = new char[h][w];

            Queue<Position> fires = new LinkedList<>();
            int[][] visited = new int[h][w]; //  // 1이면 사람 이동 방문, -1이면 불이 이동
            for (int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = line.charAt(k);
                    if (map[j][k] == '@') {
                        cpy = j;
                        cpx = k;
                        map[j][k] = '.';
                        visited[j][k] = 1;
                    } else if (map[j][k] == '*') {
                        fires.add(new Position(k, j, 0));
                        visited[j][k] = -1;
                    }
                }
            }

            int escapeTime = calculateEscapeTime(map, fires, visited, cpy, cpx);
            if (escapeTime == -1) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(escapeTime).append("\n");
            }
        }

        System.out.println(sb);
    }

    /*
    . : 빈 공간
    # : 벽
    @ : 상근이 시작 위치
    *: 불
     */
    private static int calculateEscapeTime(char[][] map, Queue<Position> fires, int[][] visited, int cpy, int cpx) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(cpx, cpy, 0));
        int nextTime = 0;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            // 가장자리면 다음 이동에 탈출!
            if (position.y == 0 || position.y == map.length - 1 || position.x == 0 || position.x == map[0].length - 1) {
                return position.time + 1;
            }

            // 다음 위치가 이동한 후의 위치면 불을 번지게 함
            if (nextTime == position.time) {
                spreadFire(map, fires, visited, dx, dy, position.time);
                nextTime++;
            }

            // 불이 번진 뒤 이동!
            for (int i = 0; i < 4; i++) {
                int nx = position.x + dx[i];
                int ny = position.y + dy[i];
                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length || visited[ny][nx] == 1) {
                    continue;
                }

                if (map[ny][nx] == '.') {
                    visited[ny][nx] = 1;
                    queue.add(new Position(nx, ny, position.time + 1));
                }
            }
        }

        return -1; // -1은 Impossible
    }

    private static void spreadFire(char[][] map, Queue<Position> fires, int[][] visited, int[] dx, int[] dy,
                                   int time) {
        while (!fires.isEmpty() && fires.peek().time <= time) {
            Position fp = fires.poll();
            for (int k = 0; k < 4; k++) {
                int ny = fp.y + dy[k];
                int nx = fp.x + dx[k];
                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length || map[ny][nx] == '#'
                        || visited[ny][nx] == -1) {
                    continue;
                }

                map[ny][nx] = '*';
                visited[ny][nx] = -1;
                fires.add(new Position(nx, ny, time + 1));
            }
        }
    }

    static class Position {
        int x;
        int y;
        int time;

        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
/*
Input
5
4 3
####
#*@.
####
7 6
###.###
#*#.#*#
#.....#
#.....#
#..@..#
#######
7 4
###.###
#....*#
#@....#
.######
5 5
.....
.***.
.*@*.
.***.
.....
3 3
###
#@#
###

Output
2
5
IMPOSSIBLE
IMPOSSIBLE
IMPOSSIBLE
---
Input
1
3 3
*.*
.@.
*.*

Output
IMPOSSIBLE
*/

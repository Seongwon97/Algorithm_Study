package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/17143
// 낚시왕
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Shark[][] map = new Shark[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 방향 쉽게 바꾸기위해 입력받은 상하좌우(1 2 3 4) -> 상좌하우(0 1 2 3)로 변경
            if (d == 1) {
                d = 0;
            } else if (d == 4) {
                d = 1;
            }
            map[r][c] = new Shark(r, c, s, d, z); // 격자판에 상어 저장
        }

        int answer = 0;
        int[] dx = {-1, 0, 1, 0}; //상 좌 하 우 순
        int[] dy = {0, -1, 0, 1};
        for (int col = 1; col <= C; col++) {
            // 1. 낚시왕 이동
            for (int row = 1; row <= R; row++) {
                if (map[row][col] != null) {
                    answer += map[row][col].z; // 2. 가장 가까운 상어 크기 정답 변수에 저장
                    map[row][col] = null; // map에서 상어 없애기
                    break;
                }
            }

            // 3. 상어 이동
            Queue<Shark> queue = new LinkedList<>();
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (map[i][j] != null) { // 현재 map에 있는 상어들 큐에 추가
                        queue.add(map[i][j]);
                    }
                }
            }

            map = new Shark[R + 1][C + 1]; // 새로운 낚시판 만들기위해 배열 초기화

            // 모든 상어 한마리씩 꺼내서 이동
            while (!queue.isEmpty()) {
                Shark shark = queue.poll();

                int speed = shark.s; // 시간초과로 최소한의 이동을 위해 나머지 연산
                if (shark.d == 0 || shark.d == 2) { //상 하
                    speed %= (R - 1) * 2;
                } else if (shark.d == 1 || shark.d == 3) { //좌 우
                    speed %= (C - 1) * 2;
                }

                for (int s = 0; s < speed; s++) {
                    // 현재 r, c에 방향에 맞게 1칸씩 추가하며 위치 이동
                    int newR = shark.r + dx[shark.d];
                    int newC = shark.c + dy[shark.d];

                    // 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
                    if (newR <= 0 || newR > R || newC <= 0 || newC > C) {
                        shark.r -= dx[shark.d]; // 다시 값 돌려주고
                        shark.c -= dy[shark.d];
                        shark.d = (shark.d + 2) % 4; // 방향 반대로
                        continue;
                    }

                    // 위치 벗어나지 않을때는 새로운 위치로 이동
                    shark.r = newR;
                    shark.c = newC;
                }

                // 4. 새로운 위치가 빈 공간인지 이미 상어가 있는지 확인
                if (map[shark.r][shark.c] != null) { // 이미 상어가 있다면 두 상어 크기 비교
                    if (map[shark.r][shark.c].z < shark.z) { // 기존 상어보다 현재 상어가 크다면
                        map[shark.r][shark.c] = shark;
                    }
                } else { // 없다면 현재 상어 바로 넣어줌
                    map[shark.r][shark.c] = shark;
                }
            }
        }

        System.out.println(answer);
    }

    static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
/*
Input
4 6 8
4 1 3 3 8
1 3 5 2 9
2 4 8 4 1
4 5 0 1 4
3 3 1 2 7
1 5 8 4 3
3 6 2 1 2
2 2 2 3 5

Output
22
---
Input
3 10 3
1 7 37 4 1
2 8 37 4 10
3 9 37 4 100

Output
101
---
Input
1 5 1
1 2 1 3 100

Output
0
---
Input
1 6 6
1 1 0 4 1
1 2 1 4 2
1 3 2 4 3
1 4 3 4 4
1 5 4 4 5
1 6 5 4 6

Output
1
*/

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12886
// 돌 그룹
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int answer = solution(A, B, C);
        System.out.println(answer);
    }

    private static int solution(int a, int b, int c) {
        boolean[][] visited = new boolean[1501][1501];

        Queue<Situation> queue = new LinkedList<>();
        queue.add(new Situation(a, b, c));
        visited[a][b] = true;
        while (!queue.isEmpty()) {
            Situation situation = queue.poll();
            int sa = situation.a;
            int sb = situation.b;
            int sc = situation.c;

            if (sa == sb && sb == sc) {
                return 1;
            }

            int na, nb, nc;
            if (sa != sb) {
                if (sa > sb) {
                    na = sa - sb;
                    nb = sb * 2;
                } else {
                    na = sa * 2;
                    nb = sb - sa;
                }
                nc = sc;
                if (!visited[na][nb]) {
                    queue.add(new Situation(na, nb, nc));
                    visited[na][nb] = true;
                }
            }

            if (sb != sc) {
                if (sb > sc) {
                    nb = sb - sc;
                    nc = sc * 2;
                } else {
                    nb = sb * 2;
                    nc = sc - sb;
                }
                na = sa;
                if (!visited[na][nb]) {
                    queue.add(new Situation(na, nb, nc));
                    visited[na][nb] = true;
                }
            }

            if (sa != sc) {
                if (sa > sc) {
                    na = sa - sc;
                    nc = sc * 2;
                } else {
                    na = sa * 2;
                    nc = sc - sa;
                }
                nb = sb;
                if (!visited[na][nb]) {
                    queue.add(new Situation(na, nb, nc));
                    visited[na][nb] = true;
                }
            }
        }

        return 0;
    }

    static class Situation {
        int a;
        int b;
        int c;

        public Situation(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
/*
Input
10 15 35

Output
1
---
Input
1 1 2

Output
0
*/

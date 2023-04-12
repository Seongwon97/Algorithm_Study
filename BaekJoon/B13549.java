package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13549
// 숨바꼭질 3
public class Main {
    private static final int MAX_RANGE = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX_RANGE + 1];
        int answer = Integer.MAX_VALUE;
        Queue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(N, 0));
        visited[N] = true;
        while (!queue.isEmpty()) {
            Position polled = queue.poll();
            visited[polled.position] = true;
            if (polled.position == K) {
                answer = polled.time;
                break;
            }

            if (polled.position - 1 >= 0 && !visited[polled.position - 1]) {
                queue.add(new Position(polled.position - 1, polled.time + 1));
            }
            if (polled.position + 1 <= MAX_RANGE && !visited[polled.position + 1]) {
                queue.add(new Position(polled.position + 1, polled.time + 1));
            }
            if (polled.position * 2 <= MAX_RANGE && !visited[polled.position * 2]) {
                queue.add(new Position(polled.position * 2, polled.time));
            }
        }

        System.out.println(answer);
    }

    static class Position implements Comparable<Position> {
        int position;
        int time;

        public Position(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Position o) {
            return this.time - o.time;
        }
    }
}
/*
Input
5 17

Output
2
*/

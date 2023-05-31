package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/19598
// 최소 회의실 개수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Time> queue = new PriorityQueue<>(Comparator.comparingInt(time -> time.start));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Time(start, end));
        }

        Queue<Time> running = new PriorityQueue<>(Comparator.comparingInt(time -> time.end));
        int numOfRooms = 0;
        while (!queue.isEmpty()) {
            Time nextConference = queue.poll();
            running.add(nextConference);
            while (!running.isEmpty() && running.peek().end <= nextConference.start) {
                running.poll();
            }

            numOfRooms = Math.max(numOfRooms, running.size());
        }

        System.out.println(numOfRooms);
    }

    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
/*
Input
3
0 40
15 30
5 10

Output
2
---
Input
2
10 20
5 10

Output
1
*/

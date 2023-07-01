package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13334
// 철로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Section> sections = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            sections.add(new Section(Math.min(h, o), Math.max(h, o)));
        }
        Collections.sort(sections);
        int d = Integer.parseInt(br.readLine());

        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            Section section = sections.get(i);
            if (section.end - section.start > d) {
                continue;
            }

            pq.add(section.start);
            while (!pq.isEmpty() && pq.peek() < section.end - d) {
                pq.poll();
            }

            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }

    static class Section implements Comparable<Section> {
        int start;
        int end;

        public Section(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Section o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
/*
Input
8
5 40
35 25
10 20
10 25
30 50
50 60
30 25
80 100
30

Output
4
---
Input
4
20 80
70 30
35 65
40 60
10

Output
0
---
Input
5
-5 5
30 40
-5 5
50 40
5 -5
10

Output
3
*/

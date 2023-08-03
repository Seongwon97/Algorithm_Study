package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2109
// 순회강연
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(d, p));
        }

        Collections.sort(lectures);

        int answer = 0;
        boolean[] visited = new boolean[10001];
        for (Lecture lecture : lectures) {
            for (int i = lecture.day; i >= 1; i--) {
                if (!visited[i]) {
                    answer += lecture.pay;
                    visited[i] = true;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    static class Lecture implements Comparable<Lecture> {
        int day;
        int pay;

        public Lecture(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.pay - this.pay;
        }
    }
}
/*
Input
7
20 1
2 1
10 3
100 2
8 2
5 20
50 10

Output
185
*/

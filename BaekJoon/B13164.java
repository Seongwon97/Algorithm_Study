package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13164
// 행복 유치원
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] heights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            Interval interval = new Interval(i, heights[i + 1] - heights[i]);
            intervals.add(interval);
        }

        Collections.sort(intervals);

        // 가장 weight이 높은거 빼기
        int[] startIdx = new int[K - 1];
        for (int i = 0; i < K - 1; i++) {
            Interval interval = intervals.get(i);
            startIdx[i] = interval.startIdx;
        }

        int answer = 0;
        int lastIdx = 0;
        Arrays.sort(startIdx);
        for (int idx : startIdx) {
            answer += (heights[idx] - heights[lastIdx]);
            lastIdx = idx + 1;
        }

        answer += (heights[N - 1] - heights[lastIdx]);
        System.out.println(answer);
    }

    public static class Interval implements Comparable<Interval> {
        int startIdx;
        int weight;

        public Interval(int startIdx, int weight) {
            this.startIdx = startIdx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Interval o) {
            return o.weight - this.weight;
        }
    }
}
/*
Input
5 3
1 3 5 6 10

Output
3
*/

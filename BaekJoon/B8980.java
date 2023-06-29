package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/8980
// 택배
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        List<Request> requests = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int numOfBoxes = Integer.parseInt(st.nextToken());
            requests.add(new Request(start, end, numOfBoxes));
        }

        Collections.sort(requests);

        int answer = 0;
        int[] box = new int[N + 1];
        for (Request request : requests) {
            int start = request.start;
            int end = request.end;
            int numOfBoxes = request.numOfBoxes;

            int max = 0;
            for (int i = start; i < end; i++) {
                max = Math.max(max, box[i]);
            }

            int loadToPossible = Math.min(C - max, numOfBoxes);
            answer += loadToPossible;
            for (int i = start; i < end; i++) {
                box[i] += loadToPossible;
            }
        }

        System.out.println(answer);
    }

    static class Request implements Comparable<Request> {
        int start;
        int end;
        int numOfBoxes;

        public Request(int start, int end, int numOfBoxes) {
            this.start = start;
            this.end = end;
            this.numOfBoxes = numOfBoxes;
        }

        @Override
        public int compareTo(Request o) {
            return this.end - o.end;
        }
    }
}
/*
Input
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20

Output
70
---
Input
6 60
5
1 2 30
2 5 70
5 6 60
3 4 40
1 6 40

Output
150
*/

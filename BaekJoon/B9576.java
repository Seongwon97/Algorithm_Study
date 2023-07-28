package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9576
// 책 나눠주기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes.add(new Node(a, b));
            }
            Collections.sort(nodes);

            int answer = 0;
            boolean[] isLend = new boolean[N + 1];
            for (Node node : nodes) {
                for (int i = node.a; i <= node.b; i++) {
                    if (!isLend[i]) {
                        isLend[i] = true;
                        answer++;
                        break;
                    }
                }
            }

            System.out.println(answer);
        }
    }

    static class Node implements Comparable<Node> {
        int a;
        int b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return this.b - o.b;
        }
    }
}
/*
Input
1
2 3
1 2
1 2
1 2

Output
2
*/

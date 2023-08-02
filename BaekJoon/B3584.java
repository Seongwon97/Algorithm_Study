package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3584
// 가장 가까운 공통 조상
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] parents = new int[N + 1];
            for (int j = 1; j <= N; j++) { // 부모를 자기 자신으로 초기화
                parents[j] = j;
            }

            for (int j = 0; j < N - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                parents[B] = A;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            List<Integer> visitedNode = new ArrayList<>(); // 첫 번째 노드가 방문한 노드들 탐색
            while (parents[node1] != node1) {
                visitedNode.add(node1);
                node1 = parents[node1];
            }
            visitedNode.add(node1);

            int answer = 0;
            while (!visitedNode.contains(node2)) {
                answer++;
                node2 = parents[node2];
            }

            System.out.println(node2);
        }
    }
}
/*
Input
2
16
1 14
8 5
10 16
5 9
4 6
8 4
4 10
1 13
6 15
10 11
6 7
10 2
16 3
8 1
16 12
16 7
5
2 3
3 4
3 1
1 5
3 5

Output
4
3
*/

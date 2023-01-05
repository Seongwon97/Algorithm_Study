package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 특정 거리의 도시 찾기 (BFS)
// https://www.acmicpc.net/problem/18352
public class B18352 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 도시의 개수
            int M = Integer.parseInt(st.nextToken()); // 도로의 개수
            int K = Integer.parseInt(st.nextToken()); // 거리 정보
            int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

            int[] minDistance = new int[N + 1];
            Arrays.fill(minDistance, -1);
            minDistance[X] = 0;
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                graph.get(A).add(B);
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(X);
            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph.get(now)) {
                    if (minDistance[next] == -1) {
                        queue.offer(next);
                        minDistance[next] = minDistance[now] + 1;
                    }
                }
            }

            boolean hasNode = false;
            for (int i = 1; i < minDistance.length; i++) {
                if (minDistance[i] == K) {
                    System.out.println(i);
                    hasNode = true;
                }
            }

            if (!hasNode) {
                System.out.println(-1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Input
4 4 2 1
1 2
1 3
2 3
2 4

Output
4
---
Input
4 3 2 1
1 2
1 3
1 4

Output
-1
---
Input
4 4 1 1
1 2
1 3
2 3
2 4

Output
2
3
 */

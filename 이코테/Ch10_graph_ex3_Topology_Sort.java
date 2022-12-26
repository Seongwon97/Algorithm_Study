package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 커리큘럼 (Topology)
public class Ch10_graph_ex3_Topology_Sort {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 1; i < N + 1; i++) {
                graph.put(i, new ArrayList<>());
            }
            int[] time = new int[N + 1];
            int[] indegree = new int[N + 1];

            for (int i = 1; i < N + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                time[i] = Integer.parseInt(st.nextToken());

                while (true) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == -1) {
                        break;
                    }
                    graph.get(input).add(i);
                    indegree[i]++;
                }
            }

            topologySort(graph, time, indegree);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void topologySort(Map<Integer, List<Integer>> graph, int[] time, int[] indegree) {
        int[] result = time.clone();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < time.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int lecture : graph.get(now)) {
                result[lecture] = Math.max(result[lecture], result[now] + time[lecture]);
                indegree[lecture]--;

                if (indegree[lecture] == 0) {
                    queue.offer(lecture);
                }
            }
        }

        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
/*
Input
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1

Output
10
20
14
18
17
 */

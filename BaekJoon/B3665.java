package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 최종 순위
// https://www.acmicpc.net/problem/3665
public class B3665 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < T; i++) {
                int n = Integer.parseInt(br.readLine());
                int[] lastRanking = new int[n];
                int[] indegree = new int[n + 1];
                boolean[][] graph = new boolean[n + 1][n + 1];

                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    lastRanking[j] = Integer.parseInt(st.nextToken());
                }

                // 작년 성적으로 진입 차수 데이터 추가
                for (int j = 0; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        graph[lastRanking[j]][lastRanking[k]] = true;
                        indegree[lastRanking[k]]++;
                    }
                }

                int m = Integer.parseInt(br.readLine());
                for (int j = 0; j < m; j++) {
                    st = new StringTokenizer(br.readLine());
                    int teamA = Integer.parseInt(st.nextToken());
                    int teamB = Integer.parseInt(st.nextToken());
                    if (graph[teamA][teamB]) {
                        graph[teamA][teamB] = false;
                        graph[teamB][teamA] = true;
                        indegree[teamA]++;
                        indegree[teamB]--;
                    } else {
                        graph[teamA][teamB] = true;
                        graph[teamB][teamA] = false;
                        indegree[teamA]--;
                        indegree[teamB]++;
                    }
                }
                topologySort(sb, n, indegree, graph);
            }

            System.out.println(sb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void topologySort(StringBuilder sb, int n, int[] indegree, boolean[][] graph) {
        List<Integer> newRanking = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int j = 1; j < n + 1; j++) {
            if (indegree[j] == 0) {
                queue.add(j);
            }
        }

        boolean hasManyCase = false;
        boolean hasCycle = false;

        for (int j = 0; j < n; j++) {
            if (queue.size() == 0) {
                hasCycle = true;
                break;
            }

            if (queue.size() >= 2) {
                hasManyCase = true;
                break;
            }

            int polledTeam = queue.poll();
            newRanking.add(polledTeam);
            for (int k = 1; k < n + 1; k++) {
                if (graph[polledTeam][k]) {
                    indegree[k]--;
                    if (indegree[k] == 0) {
                        queue.add(k);
                    }
                }
            }
        }

        if (hasCycle) {
            sb.append("IMPOSSIBLE");
        } else if (hasManyCase) {
            sb.append("?");
        } else {
            for (int team : newRanking) {
                sb.append(team)
                        .append(" ");
            }
        }
        sb.append("\n");
    }
}

/*
Input
3
5
5 4 3 2 1
2
2 4
3 4
3
2 3 1
0
4
1 2 3 4
3
1 2
3 4
2 3

Output
5 3 2 4 1
2 3 1
IMPOSSIBLE
*/

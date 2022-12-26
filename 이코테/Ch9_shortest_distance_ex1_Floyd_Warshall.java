package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미래 도시 (Floyd-Warcshall)
public class Ch9_shortest_distance_ex1_Floyd_Warshall {

    private static final int MAX_DISTANCE = 101;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N + 1][N + 1];

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (i != j) {
                        graph[i][j] = MAX_DISTANCE;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
                graph[b][a] = 1;
            }

            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            System.out.println(floyedWarshall(graph, 1, K, X));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int floyedWarshall(int[][] graph, int start, int stopOver, int end) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                for (int k = 1; k < graph.length ; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int result = graph[start][stopOver] + graph[stopOver][end];

        if (result == MAX_DISTANCE) {
            return -1;
        }
        return result;
    }
}
/* Input
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5
-> 1번회사에서 5번 회사를 방문 후 4번으로 이동
*/

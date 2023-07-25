package test;

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

// https://www.acmicpc.net/problem/2056
// 작업
// 위상정렬
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> precedingWorks = new HashMap<>();
        // 나를 선행작업으로 갖고 있는 일을 저장
        for (int i = 1; i <= N; i++) {
            precedingWorks.put(i, new ArrayList<>());
        }

        int[] times = new int[N + 1];
        int[] numOfPrecedingWorks = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int numOfPrecedingWork = Integer.parseInt(st.nextToken());

            for (int j = 0; j < numOfPrecedingWork; j++) {
                int job = Integer.parseInt(st.nextToken());
                precedingWorks.get(job).add(i);
                numOfPrecedingWorks[i]++;
            }
        }

        System.out.println(topologySort(N, precedingWorks, numOfPrecedingWorks, times));
    }

    private static int topologySort(int N, Map<Integer, List<Integer>> precedingWorks, int[] numOfPrecedingWorks,
                                    int[] times) {
        Queue<Integer> q = new LinkedList<>();

        int[] endOfWorkTimes = new int[N + 1]; // 각각의 작업이 끝나는 시간
        for (int i = 1; i <= N; i++) {
            endOfWorkTimes[i] = times[i];
            if (numOfPrecedingWorks[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : precedingWorks.get(now)) {
                numOfPrecedingWorks[next]--;

                endOfWorkTimes[next] = Math.max(endOfWorkTimes[next], endOfWorkTimes[now] + times[next]);

                if (numOfPrecedingWorks[next] == 0) {
                    q.offer(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, endOfWorkTimes[i]);
        }

        return answer;
    }
}
/*
Input
7
5 0
1 1 1
3 1 2
6 1 1
1 2 2 4
8 2 2 4
4 3 3 5 6

Output
23
*/

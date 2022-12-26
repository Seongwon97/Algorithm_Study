package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팀 결성 (Union Find)
public class Ch10_graph_ex1_Union_Find {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] team = new int[N + 1];
            for (int i = 0; i < N + 1; i++) {
                team[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (command == 0) {
                    unionTeam(team, a, b);
                } else if (command == 1) {
                    int parentA = findParent(team, a);
                    int parentB = findParent(team, b);

                    if (parentA == parentB) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void unionTeam(int[] team, int a, int b) {
        int parentA = findParent(team, a);
        int parentB = findParent(team, b);

        if (parentA < parentB) {
            team[b] = parentA;
        } else {
            team[a] = parentB;
        }
    }

    private static int findParent(int[] team, int a) {
        if (team[a] != a) {
            team[a] = findParent(team, team[a]);
        }
        return team[a];
    }
}
/*
Input
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1

Output
NO
NO
YES
 */

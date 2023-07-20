package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16437
// 양 구출 작전
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        Island[] islands = new Island[N + 1];
        islands[1] = new Island('S', 0);

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            tree.get(p).add(i);
            islands[i] = new Island(t, a);
        }

        System.out.println(search(1, islands, tree));
    }

    static long search(int index, Island[] islands, List<List<Integer>> tree) {
        long sum = 0;
        for (int next : tree.get(index)) {
            sum += search(next, islands, tree);
        }

        if (islands[index].species == 'S') {
            return sum + islands[index].amount;
        } else {
            return (sum - islands[index].amount < 0) ? 0 : sum - islands[index].amount;
        }
    }

    static class Island {
        char species;
        int amount;

        public Island(char species, int amount) {
            this.species = species;
            this.amount = amount;
        }
    }
}
/*
Input
4
S 100 3
W 50 1
S 10 1

Output
60
---
Input
7
S 100 1
S 100 1
W 100 1
S 1000 2
W 1000 2
S 900 6

Output
1200
*/

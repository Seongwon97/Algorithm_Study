package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/16987
// 계란으로 계란치기
public class Main {
    private static int answer = 0;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Egg[] eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        dfs(0, 0, eggs);

        System.out.println(answer);
    }

    static void dfs(int current, int count, Egg[] eggs) {
        if (current == N) {
            answer = Math.max(answer, count);
            return;
        }

        Egg currentEgg = eggs[current];
        if (currentEgg.durability <= 0 || count == N - 1) {
            dfs(current + 1, count, eggs);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (current == i) {
                continue;
            }

            Egg nextEgg = eggs[i];
            if (nextEgg.durability <= 0) {
                continue;
            }

            currentEgg.durability -= nextEgg.weight;
            nextEgg.durability -= currentEgg.weight;

            int addCount = 0;
            if (currentEgg.durability <= 0) {
                addCount++;
            }

            if (nextEgg.durability <= 0) {
                addCount++;
            }

            dfs(current + 1, count + addCount, eggs);

            currentEgg.durability += nextEgg.weight;
            nextEgg.durability += currentEgg.weight;
        }
    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
/*
Input
3
8 5
1 100
3 5

Output
1 1 0 0
*/

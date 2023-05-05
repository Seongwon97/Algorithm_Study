package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2624
// 동전 바꿔주기
public class Main {

    private static final int MAX_MONEY = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<Coin> coins = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int coin = Integer.parseInt(st.nextToken());
            int numOfCoins = Integer.parseInt(st.nextToken());
            coins.add(new Coin(coin, numOfCoins));
        }

        Collections.sort(coins);

        int[] dp = new int[MAX_MONEY + 1];
        for (Coin coin : coins) {
            // 기존에 있는 돈에 동전을 각각 더해서 경우의 수 올리기
            for (int j = MAX_MONEY; j >= 0; j--) {
                if (dp[j] != 0) {
                    for (int i = 1; i <= coin.count; i++) {
                        int newMoney = j + (i * coin.value);
                        if (newMoney <= MAX_MONEY) {
                            dp[newMoney] = dp[newMoney] + dp[j];
                        }
                    }
                }
            }

            // 해당 동전으로만 만들 수 있는 경우의 수 만들기
            for (int i = 1; i <= coin.count; i++) {
                int newMoney = i * coin.value;
                if (newMoney <= MAX_MONEY) {
                    dp[newMoney]++;
                }
            }
        }

        System.out.println(dp[T]);
    }

    static class Coin implements Comparable<Coin> {
        int value;
        int count;

        public Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Coin c) {
            return this.value - c.value;
        }
    }
}
/*
Input
20
3
5 3
10 2
1 5

Output
4
*/

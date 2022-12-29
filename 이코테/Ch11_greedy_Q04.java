package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 만들 수 없는 금액 (Greedy)
public class Ch11_greedy_Q04 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[N];
            for (int i = 0; i < N; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(coins);

            int target = 1;
            for (int coin : coins) {
                if (target < coin) {
                    break;
                }
                target += coin;
            }

            System.out.println(target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Input
0001100

Output
1
 */

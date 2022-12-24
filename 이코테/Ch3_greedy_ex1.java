package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 거스름돈
public class Ch3_greedy_ex1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());

        int[] coinType = {500, 100, 50, 10};
        int numOfCoin = 0;
        for (int coin : coinType) {
            numOfCoin += (money / coin);
            money %= coin;
        }

        System.out.println(numOfCoin);
    }
}

package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class GreedyAlgorithmExample {
	public static void main(String[] args) {
		Integer[] coinList = {500, 600, 50, 1};
		// Arrays.sort로 오른차순으로 정렬할 때는 int array를 사용가능.
		// 하지만 Arrays.sort를 할 때 내림차순으로 하려고 Collections.reverseOrder()을 하면
		// int array가 아닌 Integer array로 해야한다.
		Arrays.sort(coinList, Collections.reverseOrder());
		
		System.out.println(minCoinCount(coinList, 4720));
 	}
	public static HashMap<Integer, Integer> minCoinCount(Integer[] coinList, int pay){
		HashMap<Integer, Integer> result = new HashMap<>();
		int coinNum;
		int money = pay;
		int totalCoin = 0;
		for (int coin: coinList) {
			coinNum = money/coin;
			money -= (coin*coinNum);
			result.put(coin, coinNum);
		}
		return result;
	}
}

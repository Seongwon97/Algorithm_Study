package baekjoon;

import java.util.*;
import java.io.*;

public class B5585 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] moneyList = {500, 100, 50, 10, 5, 1};
		int remain = 0;
		int totalCoin = 0;
		
		int money = Integer.parseInt(br.readLine());
		remain = 1000 - money;
		
		int index = 0;
		while (remain != 0) {
			totalCoin += (remain/moneyList[index]);
			remain %= moneyList[index];
			index++;
			
		}
		
		System.out.println(totalCoin);
	}

}

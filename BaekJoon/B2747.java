package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2747 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int[] fibo = new int[num+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i=2; i<=num; i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		System.out.println(fibo[num]);
	}

}

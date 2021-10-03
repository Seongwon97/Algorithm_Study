package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1568 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());

		int time = 0;
		int minusNum = 1;
		
		while(true) {
			if (minusNum > num) minusNum = 1;
			
			num -= (minusNum++);
			time++;
			if (num == 0) break;
			
		}
		System.out.println(time);
	}
}

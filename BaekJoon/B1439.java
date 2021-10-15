package baeckjoon;

import java.io.*;
import java.util.*;

public class B1439 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int count0 = 0; // 전부 0으로 만드는 경우
		int count1 = 0; // 전부 1로 만드는 경우
		
		// 첫째 문자에 따라 뒤집을 횟수 +
		if (str.charAt(0)=='0') count1++;
		else count0++;
		
		
		for(int i=0; i<str.length()-1; i++) {
			if (str.charAt(i) != str.charAt(i+1)) {
				if(str.charAt(i+1) =='0') count1++;
				else count0++;
			}
		}
		
		System.out.println(Math.min(count0, count1));
	}

}

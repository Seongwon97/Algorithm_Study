package baeckjoon;

import java.util.*;
import java.io.*;

public class B1094 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int stick = 64;
		int result = 0;
		int x = Integer.parseInt(br.readLine());
		
		while(x>0) {
			if (stick > x) stick /= 2;
			else {
				result++;
				x -= stick;
			}
		}
		System.out.println(result);
	}
	

}

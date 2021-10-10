package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {

	static int count;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		recursive((int)Math.pow(2, n), row, column);
		
		System.out.println(count);
		
	}
	
	public static void recursive(int n, int r, int c) {
		if(n==1)
			return;
		
		if (r < n/2 && c < n/2) {
			recursive(n/2, r, c);
			
		}
		else if (r < n/2 && c >= n/2) {
			count += (n * n / 4);
			recursive(n/2, r, c-n/2);	
		}
		else if (r >= n/2 && c < n/2) {
			count += (n * n / 4) *2;
			recursive(n/2, r-n/2, c);	
		}
		else {
			count += (n * n / 4) * 3;
			recursive(n/2, r-n/2, c-n/2);	
		}
		
		
	}

}

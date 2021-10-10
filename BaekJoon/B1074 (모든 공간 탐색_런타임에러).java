package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {

	static int count;
	static int row;
	static int column;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		
		recursive((int)Math.pow(2, n), 0, 0);
		
		
	}
	
	public static boolean recursive(int n, int r, int c) {
		if (n == 2) {
			if (row ==r && column == c) {
				System.out.println(count);
				return true;
			}
			count++;
			
			if (row ==r && column == (c+1)) {
				System.out.println(count);
				return true;
			}
			count++;
			
			if (row ==(r+1) && column == c) {
				System.out.println(count);
				return true;
			}
			count++;
			
			if (row ==(r+1) && column == (c+1)) {
				System.out.println(count);
				return true;
			}
			count++;
			return false;
		}
		
		if (recursive(n/2, r, c)) return true;
		if (recursive(n/2, r, c + n/2)) return true;
		if (recursive(n/2, r + n/2, c)) return true;
		if (recursive(n/2, r + n/2, c + n/2)) return true;
		
		return false;
	}

}

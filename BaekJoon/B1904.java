package baekjoon;

import java.io.*;
public class B1904 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		
		arr[1] = 1;
		if (n >= 2) arr[2] = 2;
		
		if (n >= 3) {
			for (int i=3; i<=n; i++) {
				arr[i] = (arr[i-1] + arr[i-2]) % 15746;
			}
		}
		
		System.out.println(arr[n]);
	}

}

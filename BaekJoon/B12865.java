package backjoon;

import java.io.*;
import java.util.StringTokenizer;

public class B12865{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][k+1]; // k개의 배열이 필요하나 index계산을 쉽게 하기 위해 k+1개 생성
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			
			for (int j=1; j<=k; j++) {
				arr[i][j] =j < w? arr[i-1][j] : Math.max(v+arr[i-1][j-w], arr[i-1][j]);
			}
		}
		
		System.out.println(arr[n][k]);
	}

}

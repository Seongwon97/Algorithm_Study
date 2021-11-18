package baekjoon;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1051 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N][M];
		
		for (int i=0; i<N; i++) {
			matrix[i] = Arrays.asList(br.readLine().split("")).stream().mapToInt(Integer::parseInt).toArray();
		}
		
		int max = 1;
		for (int i=0; i<(N-1); i++) {
			for (int j=0; j<(M-1); j++) {
				if ((i+1) >= N || (j+1) >= M) continue;
				for (int k=1; (k+i) < N && (k+j) < M; k++) {
					int temp = matrix[i][j];
					if (temp == matrix[i+k][j] && temp == matrix[i][j+k] && temp == matrix[i+k][j+k] && max < Math.pow(k+1, 2)) {
						max = (int) Math.pow(k+1, 2);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}

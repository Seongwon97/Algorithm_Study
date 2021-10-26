package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520 {
	
	static int M;
	static int N;
	static int[][] matrix;
	static int[][] dp;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		matrix = new int[M][N];
		dp = new int[M][N];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; // 방문하지 않은 곳은 -1로 초기화
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	
	static int dfs(int y, int x) {
		if (y==(M-1) && x==(N-1)) {
			return 1;
		}
		if (dp[y][x] != -1) return dp[y][x];
		
		
		// 현재 값 초기화
		dp[y][x] = 0;
		for (int i=0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			
			if (0 <= cx && cx < N && 0 <= cy && cy < M) {
				if (matrix[cy][cx] < matrix[y][x]) {
					dp[y][x] += dfs(cy, cx);
				}		
			}
		}
		return dp[y][x];
	}

}

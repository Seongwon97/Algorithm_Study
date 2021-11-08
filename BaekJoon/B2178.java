package baekjoon;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class B2178 {

	static int N;
	static int M;
	static int[][] matrix;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		
		for (int i=0; i<N; i++) {
			matrix[i] = Arrays.asList(br.readLine().split("")).stream().mapToInt(Integer::parseInt).toArray();
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		boolean[][] check = new boolean[N][M];
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(0);
		queue.add(0);
		
		while(!queue.isEmpty()) {
			int r = queue.poll();
			int c = queue.poll();

			for (int i=0; i<4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || matrix[nr][nc] == 0 || check[nr][nc]) continue;
				
				matrix[nr][nc] = matrix[r][c] + 1;
				check[nr][nc] = true;
				if (nr == (N-1) && nc == (M-1)) break;
				queue.add(nr);
				queue.add(nc);
			}
			
		}
		return matrix[N-1][M-1];
	}

}

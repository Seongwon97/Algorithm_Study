package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2583 {
	
	static int result = 0;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[][] matrix;
	static boolean[][] check;
	static int M;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		matrix = new boolean[M][N];
		check = new boolean[M][N];
		
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			
			for (int r = startR; r<endR; r++) {
				for (int c = startC; c<endC; c++) {
					matrix[r][c] = true;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		int result = 0;
		for (int r = 0; r<M; r++) {
			for (int c = 0; c<N; c++) {
				if (!matrix[r][c]) {
					result++;
					list.add(bfs(r, c));
					}
			}
		}
		Collections.sort(list);
		
		bw.write(result+"\n");
		for (int i: list) bw.write(i+ " ");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs(int r, int c) {
		Queue<Point> queue = new LinkedList<>();
		int count = 0;
		queue.add(new Point(r, c));
		
		Point point;
		while (!queue.isEmpty()) {
			point = queue.poll();
			
			if (!matrix[point.r][point.c]) {
				matrix[point.r][point.c] = true;
				count++;
			}
			
			for (int i=0; i< 4; i++) {
				int nr = point.r + dy[i];
				int nc = point.c + dx[i];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N || matrix[nr][nc]) continue;

				queue.add(new Point(nr, nc));
			}
		}
		return count;
	}
	
	static class Point{
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
}

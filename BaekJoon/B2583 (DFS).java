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

import baekjoon.B16236.Point;

public class B2583 {
	
	static int result = 0;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static boolean[][] matrix;
	static boolean[][] check;
	static int M;
	static int N;
	static int count;
	
	public static void main(String[] args) throws Exception {
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
					count = 0;
					matrix[r][c] = true;
					dfs(r, c);
					
					result++;
					list.add(count);
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
	
	static void dfs(int r, int c) throws Exception {
		count++;
		for (int i=0; i< 4; i++) {
			int nr = r + dy[i];
			int nc = c + dx[i];
			if (nr < 0 || nr >= M || nc < 0 || nc >= N || matrix[nr][nc]) continue;
			
			matrix[nr][nc] = true;
			dfs(nr, nc);
		}
	}
	
}

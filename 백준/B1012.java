package baekjoon;

import java.io.*;
import java.util.*;

public class B1012 {
	static int width;
	static int height;
	static boolean[][] farm;
	static boolean[][] check;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			int numOfCabbage = Integer.parseInt(st.nextToken());
			
			farm = new boolean[width][height]; // 배추의 위치를 나타냄
			check = new boolean[width][height]; // 해당 구역을 확인했는지 체크
			for (int j=0; j< numOfCabbage; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				farm[x][y] = true;
			}
			
			int count = 0;
			for (int j=0; j< width; j++) {
				for (int k=0; k< height; k++) {
					if (farm[j][k] && !check[j][k]) {
						count++;
						dfs(j,k);
					}
				}
			}
			bw.write(count + "\n");

		}
		bw.flush();
		bw.close();
	}
	
	static void dfs(int x, int y) {
		check[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int x2 = x+dx[i];
			int y2 = y+dy[i];
			
			
			if (0 <= x2 && x2 < width && 0 <= y2 && y2 < height) {
				if (farm[x2][y2] && !check[x2][y2]) {
				dfs(x2, y2);
				}
			}
			

		}
	}

}

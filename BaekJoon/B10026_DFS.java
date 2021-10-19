package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10026_DFS {
	
	static char[][] matrix;
	static int N;
	static boolean[][] isChecked;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		matrix = new char[N][N];
		isChecked = new boolean[N][N]; // 탐색여부 체크
		
		for (int i=0; i<N; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		int result = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!isChecked[i][j]) {
					result++;
					dfs(i, j, true);
				}
			}
		}
		bw.write(result+" ");
		
		isChecked = new boolean[N][N];
		result = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!isChecked[i][j]) {
					result++;
					dfs(i, j, false);
				}
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int row, int column, boolean normal) {
		isChecked[row][column] = true;
//		System.out.println("check "+ row+" "+ column);
		boolean allFalse = true;
		
		boolean[] available; // 현재 위치에서 상하좌우로 가능한지를 나타내는 변수
		if (normal) available = isAvailable1(row, column);
		else available = isAvailable2(row, column);
		
		if (available[0] && !isChecked[row-1][column]) {
			allFalse = false;
			dfs(row-1, column, normal);
		}
		if (available[1] && !isChecked[row+1][column]) {
			allFalse = false;
			dfs(row+1, column, normal);
		}
		if (available[2] && !isChecked[row][column-1]) {
			allFalse = false;
			dfs(row, column-1, normal);
		}
		if (available[3] && !isChecked[row][column+1]) {
			allFalse = false;
			dfs(row, column+1, normal);
		}
		
	}
	// 정상인 경우
	static boolean[] isAvailable1(int r, int c) {
		boolean[] available = new boolean[4];
		if (-1 < (r-1) && matrix[r][c] == matrix[r-1][c]) // 위로 이동
			available[0] = true;
		
		if ((r+1) < N && matrix[r][c] == matrix[r+1][c]) // 아래로 이동
			available[1] = true;
		
		if (-1 < (c-1) && matrix[r][c] == matrix[r][c-1]) // 왼쪽으로 이동
			available[2] = true;
		
		if ((c+1) < N && matrix[r][c] == matrix[r][c+1]) // 오른쪽로 이동
			available[3] = true;
		
		return available;
	}
	
	// 정록색약인 경우
	static boolean[] isAvailable2(int r, int c) {
		boolean[] available = new boolean[4];
		if (-1 < (r-1)) {// 위로 이동
			if (matrix[r][c] == 'R' || matrix[r][c] == 'G') {
				if (matrix[r-1][c] == 'R' || matrix[r-1][c] == 'G')
					available[0] = true;
			}
			else if (matrix[r][c] == matrix[r-1][c]) available[0] = true;
		}
			
		
		if ((r+1) < N) { // 아래로 이동
			if (matrix[r][c] == 'R' || matrix[r][c] == 'G') {
				if (matrix[r+1][c] == 'R' || matrix[r+1][c] == 'G')
					available[1] = true;
			}
			else if (matrix[r][c] == matrix[r+1][c]) available[1] = true;
		}
		
		if (-1 < (c-1)) { // 왼쪽으로 이동
			if (matrix[r][c] == 'R' || matrix[r][c] == 'G') {
				if (matrix[r][c-1] == 'R' || matrix[r][c-1] == 'G')
					available[2] = true;
			}
			else if (matrix[r][c] == matrix[r][c-1]) available[2] = true;
		}
		
		if ((c+1) < N) {// 오른쪽로 이동
			if (matrix[r][c] == 'R' || matrix[r][c] == 'G') {
				if (matrix[r][c+1] == 'R' || matrix[r][c+1] == 'G')
					available[3] = true;
			}
			else if (matrix[r][c] == matrix[r][c+1]) available[3] = true;
		}
		
		return available;
	}

}

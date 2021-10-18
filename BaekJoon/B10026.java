package algorithm;

import java.io.*;
import java.util.*;

public class B10026 {

	static char[][] matrix;
	static int N;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		matrix = new char[N][N];
		boolean[][] isChecked1 = new boolean[N][N]; // 정상인의 탐색여부 체크
		boolean[][] isChecked2 = new boolean[N][N]; // 정록색약의 탐색 체크
		
		for (int i=0; i<N; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		int result1 = 0;
		int result2 = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!isChecked1[i][j]) {
					result1++;
					bfs(i, j, true, isChecked1);
				}
				if (!isChecked2[i][j]) {
					result2++;
					bfs(i, j, false, isChecked2);
				}
			}
		}
		bw.write(result1+" "+result2);
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 정상인은 normal이 true, 정록색약은 false
	static void bfs(int r, int c, boolean normal, boolean[][] isChecked) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] available; // 현재 위치에서 상하좌우로 가능한지를 나타내는 변수
		queue.add(r);
		queue.add(c);
		
		while(!queue.isEmpty()) {
			int row = queue.poll();
			int column = queue.poll();
			if (normal) available = isAvailable1(row, column);
			else available = isAvailable2(row, column);
			isChecked[row][column] = true;
			
			if (available[0] && !isChecked[row-1][column]) {
				queue.add(row-1);
				queue.add(column);
			}
			if (available[1] && !isChecked[row+1][column]) {
				queue.add(row+1);
				queue.add(column);
			}
			if (available[2] && !isChecked[row][column-1]) {
				queue.add(row);
				queue.add(column-1);
			}
			if (available[3] && !isChecked[row][column+1]) {
				queue.add(row);
				queue.add(column+1);
			}
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

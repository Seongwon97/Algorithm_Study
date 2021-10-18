package algorithm;

import java.util.*;
import java.io.*;

public class B1987 {
	static int result = 0;
	static char[][] matrix;
	static int R;
	static int C;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		matrix = new char[R][C];
		for (int i=0; i<R; i++) {
			matrix[i] = br.readLine().toCharArray();
		}
		
		HashSet<Character> visited = new HashSet<>();
		dfs(0, 0, visited);
		
		System.out.println(result);
		
	}
	// cr -> current row, cc-> current column
	static void dfs(int cr, int cc, HashSet<Character> visited) {
		visited.add(matrix[cr][cc]);
		
		boolean allFalse = true;
		
		boolean[] available = isAvailable(cr, cc, visited);
		
		if (available[0]) {
			allFalse = false;
			dfs(cr-1, cc, visited);
			visited.remove(matrix[cr-1][cc]);
		}
		if (available[1]) {
			allFalse = false;
			dfs(cr+1, cc, visited);
			visited.remove(matrix[cr+1][cc]);
		}
		if (available[2]) {
			allFalse = false;
			dfs(cr, cc-1, visited);
			visited.remove(matrix[cr][cc-1]);
		}
		if (available[3]) {
			allFalse = false;
			dfs(cr, cc+1, visited);
			visited.remove(matrix[cr][cc+1]);
		}
		
		if (allFalse) { // 더이상 갈 곳이 없으면 탈출
			if (result < visited.size())
				result = visited.size();
		}

	}
	
	static boolean[] isAvailable(int cr, int cc, HashSet<Character> visited) {
		boolean[] available = new boolean[4]; // 상하좌우의 가능한 정보를 담음
		
		if (-1 < (cr - 1) && !visited.contains(matrix[cr-1][cc])) // 위쪽으로 이동이 가능한지
			available[0] = true;
		
		if ((cr + 1) < R && !visited.contains(matrix[cr+1][cc])) // 아래로 이동이 가능한지
			available[1] = true;
		
		if (-1 < (cc - 1) && !visited.contains(matrix[cr][cc-1])) // 왼쪽으로 이동이 가능한지
			available[2] = true;
		
		if ((cc + 1) < C && !visited.contains(matrix[cr][cc+1])) // 오른쪽으로 이동이 가능한지
			available[3] = true;
		
		return available;
	}

}

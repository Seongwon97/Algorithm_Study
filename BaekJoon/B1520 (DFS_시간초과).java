import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int[][] matrix;
	static boolean[][] checked;
	static int result;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		matrix = new int[M][N];
		checked = new boolean[M][N];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		checked[0][0] = true;
		dfs(0, 0);

		System.out.println(result);
	}
	
	
	static void dfs(int y, int x) {
		if (y==(M-1) && x==(N-1)) {
			result++;
		}
		else {
			int currentHeight = matrix[y][x];
			for (int i=0; i<4; i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if (0 <= cx && cx < N && 0 <= cy && cy < M && !checked[cy][cx] && matrix[cy][cx] < currentHeight) {
					checked[cy][cx] = true;
					dfs(cy, cx);
					checked[cy][cx] = false;
				}
				
			}
		}
	}

}
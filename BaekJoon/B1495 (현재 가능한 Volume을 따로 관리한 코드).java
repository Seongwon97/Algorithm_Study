package baekjoon;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1495 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // Input 개수
		int S= Integer.parseInt(st.nextToken()); // 현재 볼륨
		int M = Integer.parseInt(st.nextToken()); // Max volume
		
		boolean[][] dp = new boolean[N+1][M+1];
		
		dp[0][S] = true;
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(S);
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=1; i<= N; i++) {
			int v = Integer.parseInt(st.nextToken());
			while (!list.isEmpty()) {
				int currentVolume = list.remove(0);
				if (currentVolume-v >= 0) dp[i][currentVolume-v] = true;
				if (currentVolume+v <= M) dp[i][currentVolume+v] = true;
			}
			
			for (int j=0; j<= M; j++) {
				if (dp[i][j]) list.add(j);
			}
		}
		
		int result = -1;
		for (int j=0; j<= M; j++) {
			if (dp[N][j]) result = j;
		}
		
		System.out.println(result);

	}
}

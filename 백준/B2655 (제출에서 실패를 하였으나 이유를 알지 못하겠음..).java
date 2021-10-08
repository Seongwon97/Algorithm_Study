package baekjoon;

import java.io.*;
import java.util.*;

public class B2655 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Brick> list = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int area = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Brick(i+1, area, height, weight));
		}
		
        // 넓이 기준으로 정렬하기
		Collections.sort(list);
		
		int[][] dp = new int[n][n];
		dp[0][0] = list.get(0).height;
		
		for (int i=1; i<n; i++) {
			dp[i][i] = list.get(i).height;
			for (int j=0; j<i; j++) {
				if (list.get(i).weight < list.get(j).weight) {
					dp[i][j] = dp[i-1][j] + list.get(i).height;
				}
				else dp[i][j] = dp[i-1][j];
			}
		}
//		
//		for (int i=0; i<n; i++) {
//			for (int j=0; j<n; j++) {
//				System.out.print(dp[i][j] + "  ");
//			}
//			System.out.println();
//		}

		
		// 가장 높은 높이 찾기
		int maxHeight = -1;
		int maxHeightIndex = -1;
		for (int i=0; i<n; i++) {
			if (dp[n-1][i] > maxHeight) {
				maxHeight = dp[n-1][i];
				maxHeightIndex = i;
			}
		}
		
		// 해당 line의 값을 통해 답 찾기
		ArrayList<Integer> result = new ArrayList<>();
		result.add(list.get(maxHeightIndex).id);
		for (int i=1; i<n; i++) {
			if (dp[i][maxHeightIndex] > dp[i-1][maxHeightIndex]) {
				result.add(list.get(i).id);
			}
		}
		
        // 결과 출력
		System.out.println(result.size());
		for (int i=result.size()-1; i>=0; i--) {
			System.out.println(result.get(i));
		}
	}

}

class Brick implements Comparable<Brick> {
	int id;
	int area;
	int height;
	int weight;
	
	public Brick(int id, int area, int height, int weight) {
		this.id = id; 
		this.area = area;
		this.height = height;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Brick o) {
		return this.area > o.area? -1 : 1;
	}
}
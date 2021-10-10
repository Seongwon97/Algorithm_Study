package baekjoon;

import java.io.*;
import java.util.*;

public class B2655 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Brick> list = new ArrayList<>();
		list.add(new Brick(0,0,0,0));
		for (int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int area = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Brick(i+1, area, height, weight));
		}
		
        // 넓이 기준으로 정렬하기
		Collections.sort(list);
		
		int[] dp = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			for (int j=0; j<i; j++) {
				if (list.get(i).area > list.get(j).area)
					dp[i] = Math.max(dp[i], dp[j]+list.get(i).height);
			}
		}
		
		int maxHeight = -1;
		
		for (int i=0; i<=n; i++) {
			if (maxHeight < dp[i]) maxHeight = dp[i];
		}
		
		int index = n;
		ArrayList<Integer> result = new ArrayList<>();
		
		while (index!=0) {
			if (maxHeight == dp[index]) {
				result.add(list.get(index).id);
				maxHeight -= list.get(index).height;
			}
			index--;
		}
		
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
		return this.weight < o.weight? -1 : 1;
	}
}
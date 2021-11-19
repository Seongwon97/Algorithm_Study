package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class B1049 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int set = Integer.MAX_VALUE;
		int one = Integer.MAX_VALUE;
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int setT = Integer.parseInt(st.nextToken());
			int oneT = Integer.parseInt(st.nextToken());
			
			set = Math.min(set, setT);
			one = Math.min(one, oneT);
		
		}
		
		int result = 0;
		
		if (set > (one*6)) result = one * N;	
		else {
			result = (N / 6) * set;
			
			if ((N % 6) * one < set) {
				result += ((N % 6) * one);
			}
			else result += set;
		}

		
		System.out.println(result);
	}

}

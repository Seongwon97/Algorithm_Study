package baeckjoon;

import java.io.*;
import java.util.*;

public class B2212 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		if (M >= N) {
			System.out.println(0);
			System.exit(0);
		}
		
		int[] sensor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);

		// sensor사이의 거리 계산
		Integer[] sensorDistance = new Integer[N-1]; // sensor사이의 거리
		for (int i=0; i<N-1; i++) {
			sensorDistance[i] = sensor[i+1] - sensor[i];
		}
		Arrays.sort(sensorDistance, Collections.reverseOrder());
		
		for (int i=0; i<M-1; i++) {
			sensorDistance[i] = 0;
		}
		
		int result = 0;
		for (int i=0; i<N-1; i++) {
			result += sensorDistance[i];
		}
		

		System.out.println(result);
		
	}

}

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 크레인 무게 받기
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] crane = new Integer[N];
		for (int i=0; i<N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		
		// 컨테이너 무게 받기
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Integer[] container = new Integer[M];
		for (int i=0; i<M; i++) {
			 container[i] = Integer.parseInt(st.nextToken());
		}
		
		// 크레인과 컨테이너 무게 정렬
		Arrays.sort(crane, Collections.reverseOrder());
		Arrays.sort(container, Collections.reverseOrder());
		
		if (container[0] > crane[0]) System.out.println(-1);
		else {
			int result = 0;
			int[] start = new int[N];
			Arrays.fill(start, 0);
			while (M > 0) {
				for (int i=0; i<N; i++) { // 각각의 crane이 일함
					if (M < 1) break;
					for (int j=start[i]; j<container.length; j++) {
						if (container[j]==0 || container[j] > crane[i]) {
							start[i]++;
							continue;
						}
						container[j] = 0;
						M--;
						break;
					}	
				}
				result++;
			}
			System.out.println(result);
		}
	}
}
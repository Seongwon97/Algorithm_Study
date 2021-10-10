import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k+1]; // k개의 배열이 필요하나 index계산을 쉽게 하기 위해 k+1개 생성
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			
			for (int j=w; j<=k; j++) {
				if(arr[j] < v+arr[j-w]) 
					arr[j] = v+arr[j-w];
			}

		}	
		System.out.println(arr[k]);
	}
}
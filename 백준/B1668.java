package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1668 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		int count = 0;
		int max = 0;
		
		// 값을 배열에 추가하며 왼쪽에서 봤을때 보이는 개수 카운트
		for (int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i == 0) {
				max = arr[i];
				count++;
				continue;
			}
			if (max < arr[i]) {
				max = arr[i];
				count++;
			}	
		}
		
		bw.write(count+"\n");
		
		// 오른쪽에서 봤을 때 보이는 개수 카운트
		count = 0;
		max = arr[num-1];
		for (int i=num-1; i>=0; i--) {
			if (i == num-1) {
				count++;
				continue;
			}
			if (max < arr[i]) {
				max = arr[i];
				count++;
			}		
		}
		bw.write(count+"\n");
		
		bw.flush();
		bw.close();
	}
}

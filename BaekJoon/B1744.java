package baeckjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.IOException;

public class B1744 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> positive = new ArrayList<>();
		ArrayList<Integer> negative = new ArrayList<>();
		
		int temp;
		for (int i=0; i<N; i++) {
			temp = Integer.parseInt(br.readLine());
			if (temp > 0) {
				positive.add(temp);
				continue;
			}
			negative.add(temp);
		}
		
		// 마이너스면 역순으로 해야함!
		Collections.sort(positive, Collections.reverseOrder());
		Collections.sort(negative);
		
		int result = 0;
		for (int i=0; i< positive.size(); i++) {
			int n1 = positive.get(i);
			if ((i+1) < positive.size()) {
				int n2 = positive.get(i+1);
				if ((n1+n2) < (n1*n2)) {
					result += (n1*n2);
					i++;
					continue;
				}
			}
 			result += n1;
		}
		
		for (int i=0; i< negative.size(); i++) {
			int n1 = negative.get(i);
			if ((i+1) < negative.size()) {
				int n2 = negative.get(i+1);
				if ((n1+n2) < (n1*n2)) {
					result += (n1*n2);
					i++;
					continue;
				}
			}
 			result += n1;
		}
		
		System.out.println(result);
	}
}

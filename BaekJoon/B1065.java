package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B1065 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		for (int i=1; i<=N; i++) {
			if (determine(i)) result++;
		}
		
		System.out.println(result);
		
	}
	static boolean determine(int n) {
		if (n < 10) return true;
		
		
		int first = n % 10;
		n /= 10;
		int second = n % 10;
		n /= 10;
		int diff = first - second;
		
		while (n > 0) {
			first = second;
			second = n % 10;
			n /= 10;
			if (diff != (first-second)) return false;
		}
		
		return true;
	}

}

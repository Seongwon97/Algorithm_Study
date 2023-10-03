package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A → B
// https://www.acmicpc.net/problem/16953
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int answer = 1;
		while (B != A) {
			if (B < A) {
				System.out.println(-1);
				return;
			}
			String str = String.valueOf(B);
			if (B % 2 == 0) {
				B /= 2;
			} else if (str.charAt(str.length() - 1) == '1') {
				str = str.substring(0, str.length() - 1);
				B = Integer.parseInt(str);
			} else {
				System.out.println(-1);
				return;
			}
			answer++;
		}

		System.out.println(answer);
	}
}
/*
Input
3
2
1 2
1000
3
1 5 10
100
2
5 7
22

Output
501
121
1
*/

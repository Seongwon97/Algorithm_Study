package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10539 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {

			result[i] = Integer.parseInt(st.nextToken()) * (i+1) - sum;
			sum += result[i];
			bw.write(result[i]+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

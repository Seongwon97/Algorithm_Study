import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];
		int[] cumulativeSum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			cumulativeSum[i] = cumulativeSum[i - 1] + nums[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int numOfSection = B - A + 1;
			float result = (cumulativeSum[B] - cumulativeSum[A - 1]) / (float) numOfSection;
			sb.append(String.format("%.2f", result))
				.append("\n");
		}

		System.out.println(sb.toString());
	}
}

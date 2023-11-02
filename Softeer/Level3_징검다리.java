import java.io.*;
import java.util.*;

// 풀이법: LIS 문제
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] heights = new int[N];
		for (int i = 0; i < N; i++) {
			heights[i] = Integer.parseInt(st.nextToken());
		}

		int[] lis = new int[N];
		lis[0] = heights[0];
		int lastIdx = 0;
		for (int i = 1; i < N; i++) {
			if (lis[lastIdx] < heights[i]) {
				lis[++lastIdx] = heights[i];
				continue;
			}

			int position = findPosition(lis, lastIdx, heights[i]);
			lis[position] = heights[i];
		}

		System.out.println(lastIdx + 1);
	}

	private static int findPosition(int[] lis, int lastIdx, int target) {
		int start = 0;
		int end = lastIdx;
		while (start < end) {
			int mid = (start + end) / 2;

			if (lis[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}

		return end;
	}
}

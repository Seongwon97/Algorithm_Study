package baekjoon;

// Binary Search 
// 문제를 풀 때는 데이터의 개수를 보고 예를들어 10억개와 같이 많은 데이터에 대해 돌려야한다면
// 2진 탐색과 같은 자료구조를 사용하여 log x와 같은 시간복잡도를 만들도록 출제자가 출제했다는 것을 알아차려야한다!!!

// 이진탐색은 재귀적/반복적으로 풀 수 있는데 일반적으로 문제들에서는 반복적으로 푸는게 더 유리하다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 공유기 설치
// https://www.acmicpc.net/problem/2110
public class B2110 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int[] positions = new int[N];
			for (int i = 0; i < N; i++) {
				positions[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(positions);

			int answer = 0;
			int startGap = 1;
			int endGap = positions[N - 1] - positions[0];

			while (startGap <= endGap) {
				int midGap = (startGap + endGap) / 2;
				int currentPoint = positions[0];
				int count = 1;

				for (int i = 1; i < N; i++) {
					if (positions[i] >= currentPoint + midGap) {
						currentPoint = positions[i];
						count++;
					}
				}

				if (count >= C) {
					startGap = midGap + 1;
					answer = midGap;
				} else {
					endGap = midGap - 1;
				}
			}

			System.out.println(answer);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
/*
Input
5 3
1
2
8
4
9

Output
3
 */

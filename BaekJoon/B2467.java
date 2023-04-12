import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2467
// 용액
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int start = i + 1;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;

                int sum = arr[i] + arr[mid];

                if (Math.abs(sum) < min) {
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                    min = Math.abs(sum);
                }

                if (sum < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
/*
Input
5
-99 -2 -1 4 98

Output
-99 98
---
Input
4
-100 -2 -1 103

Output
-2 -1
*/

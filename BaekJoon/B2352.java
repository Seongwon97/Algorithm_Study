package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2352
// 반도체 설계
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
        }

        int[] LIS = new int[N];
        LIS[0] = arr[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {
            if (LIS[lengthOfLIS - 1] < arr[i]) {
                LIS[lengthOfLIS] = arr[i];
                lengthOfLIS++;
                continue;
            }

            int idx = binarySearch(LIS, lengthOfLIS, arr[i]);
            LIS[idx] = arr[i];
        }

        System.out.println(lengthOfLIS);
    }

    private static int binarySearch(int[] LIS, int lengthOfLIS, int target) {
        int low = 0;
        int high = lengthOfLIS - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (LIS[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
/*
Input
6
4 2 6 3 1 5

Output
3
*/

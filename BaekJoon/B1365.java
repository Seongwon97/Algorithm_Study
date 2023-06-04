package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1365
// 꼬인 전깃줄
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = arr[0];
        int lengthOfLis = 1;
        for (int i = 1; i < N; i++) {
            if (lis[lengthOfLis - 1] < arr[i]) {
                lis[lengthOfLis] = arr[i];
                lengthOfLis++;
            } else {
                int idx = binarySearch(lis, lengthOfLis, arr[i]);
                lis[idx] = arr[i];
            }
        }

        System.out.println(N - lengthOfLis);
    }

    private static int binarySearch(int[] lis, int lengthOfLis, int num) {
        int low = 0;
        int high = lengthOfLis - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (lis[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
/*
Input
4
2 3 4 1

Output
1
*/

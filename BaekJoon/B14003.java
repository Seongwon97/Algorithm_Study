package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14003
// 가장 긴 증가하는 부분 수열 5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] lisIndex = new int[N];
        int[] LIS_temp = new int[N];
        int lengthOfLis = 1;
        LIS_temp[0] = numbers[0];
        lisIndex[0] = lengthOfLis;

        for (int i = 1; i < N; i++) {
            if (LIS_temp[lengthOfLis - 1] < numbers[i]) {
                LIS_temp[lengthOfLis] = numbers[i];
                lengthOfLis++;
                lisIndex[i] = lengthOfLis;
            } else {
                int idx = binarySearch(LIS_temp, lengthOfLis, numbers[i]);
                lisIndex[i] = idx + 1;
                LIS_temp[idx] = numbers[i];
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(lengthOfLis).append("\n");
        int[] LIS = new int[lengthOfLis];

        for (int i = N - 1; i >= 0; i--) {
            if (lisIndex[i] == lengthOfLis) {
                LIS[--lengthOfLis] = numbers[i];
            }
        }

        for (int num : LIS) {
            result.append(num).append(" ");
        }

        System.out.println(result);
    }

    private static int binarySearch(int[] lis, int lengthOfLis, int number) {
        int low = 0;
        int high = lengthOfLis - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (lis[mid] < number) {
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
6
10 20 10 30 20 50

Output
4
10 20 30 50
*/

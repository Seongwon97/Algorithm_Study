package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열 2
// https://www.acmicpc.net/problem/12015
public class B12015 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] sequence = new int[N];
            for (int i = 0; i < N; i++) {
                sequence[i] = Integer.parseInt(st.nextToken());
            }

            int[] LIS = new int[N];
            LIS[0] = sequence[0];
            int lengthOfLIS = 1;

            for (int i = 1; i < N; i++) {
                if (LIS[lengthOfLIS - 1] < sequence[i]) {
                    LIS[lengthOfLIS] = sequence[i];
                    lengthOfLIS++;
                } else {
                    int index = binarySearch(LIS, lengthOfLIS, sequence[i]);
                    LIS[index] = sequence[i];
                }
            }

            System.out.println(lengthOfLIS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int binarySearch(int[] LIS, int lengthOfLIS, int num) {
        int low = 0;
        int high = lengthOfLIS - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (LIS[mid] < num) {
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
*/

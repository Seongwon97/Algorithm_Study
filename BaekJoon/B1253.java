package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1253
// 좋다
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

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int left = 0;
            int right = N - 1;

            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    if (left != i && right != i) {
                        count++;
                        break;
                    } else if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                } else if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(count);
    }
}
/*
Input
10
1 2 3 4 5 6 7 8 9 10

Output
8
*/

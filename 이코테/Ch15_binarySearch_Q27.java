package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정렬된 배열에서 특정 수의 개수 구하기
public class Ch15_binarySearch_Q27 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int fistIndex = findFirst(numbers, x, 0, N - 1);
            int secondIndex = findLast(numbers, x, 0, N - 1);

            if (fistIndex == -1 || secondIndex == -1) {
                System.out.println(-1);
            } else {
                System.out.println(secondIndex - fistIndex + 1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findFirst(int[] numbers, int target, int start, int end) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 || target > numbers[mid - 1] && numbers[mid] == target) {
                result = mid;
                break;
            } else if (numbers[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private static int findLast(int[] numbers, int target, int start, int end) {
        int result = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == numbers.length - 1 || target < numbers[mid + 1] && numbers[mid] == target) {
                result = mid;
                break;
            } else if (numbers[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }
}

/*
Input
7 2
1 1 2 2 2 2 3

Output
4
---
Input
7 4
1 1 2 2 2 2 3

Output
-1
 */

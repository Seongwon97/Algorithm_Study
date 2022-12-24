package chapter3_greedy;

import java.util.Arrays;

// 두 배열의 원소 교체
public class Ch6_sort_ex3 {

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] a = {1, 2, 5, 4, 3};
        int[] b = {5, 5, 6, 6, 5};

        int answer = solution(n, k, a, b);
        System.out.println(answer);
    }

    private static int solution(int n, int k, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < k; i++) {
            if (a[i] < b[n - i - 1]) {
                int temp = a[i];
                a[i] = b[n - i - 1];
                b[n - i - 1] = temp;
            } else {
                break;
            }
        }

        int answer = 0;
        for (int num: a) {
            answer += num;
        }

        return answer;
    }
}

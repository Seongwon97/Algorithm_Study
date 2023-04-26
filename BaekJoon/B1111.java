package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1111
// IQ Test
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1 || (N == 2 && nums[0] != nums[1])) {
            System.out.println("A");
        } else if (N == 2) {
            System.out.println(nums[0]);
        } else {
            int a = 1;
            int b = 0;
            if (nums[1] != nums[0]) {
                a = (nums[2] - nums[1]) / (nums[1] - nums[0]);
                b = nums[1] - (nums[0] * a);
            }

            if (isAvailable(nums, a, b)) {
                int result = nums[N - 1] * a + b;
                System.out.println(result);
            } else {
                System.out.println("B");
            }
        }
    }

    private static boolean isAvailable(int[] nums, int a, int b) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] * a + b != nums[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
문제 풀이
모든 경우의 수를 구하기보다 점화식을 만들어 a를 구하는 식을 만들고,
그 후에 b를 구해 모든 숫자들이 조건을 만족하는지 체크하며 a,b의 값이 존재하는지 확인한다.
 */


/*
Input
4
1 4 13 40

Output
121
---
Input
5
1 2 3 4 5

Output
6
---
Input
2
-1 2

Output
A
---
Input
4
16 -8 4 -2

Output
B
*/


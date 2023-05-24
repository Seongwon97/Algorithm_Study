package test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15656
// N과 M (7)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        StringBuilder answer = new StringBuilder();
        List<Integer> cases = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cases.add(nums[i]);
            dfs(nums, M, answer, cases);
            cases.clear();
        }

        System.out.println(answer);
    }

    private static void dfs(int[] nums, int M, StringBuilder answer, List<Integer> cases) {
        if (cases.size() >= M) {
            for (int c : cases) {
                answer.append(c).append(" ");
            }
            answer.append("\n");
            return;
        }

        for (int num : nums) {
            cases.add(num);
            dfs(nums, M, answer, cases);
            cases.remove(cases.size() - 1);
        }
    }
}
/*
Input
3 1
4 5 2

Output
2
4
5
---
Input
4 2
9 8 7 1

Output
1 1
1 7
1 8
1 9
7 1
7 7
7 8
7 9
8 1
8 7
8 8
8 9
9 1
9 7
9 8
9 9
---
Input
3 3
1231 1232 1233

Output
1231 1231 1231
1231 1231 1232
1231 1231 1233
1231 1232 1231
1231 1232 1232
1231 1232 1233
1231 1233 1231
1231 1233 1232
1231 1233 1233
1232 1231 1231
1232 1231 1232
1232 1231 1233
1232 1232 1231
1232 1232 1232
1232 1232 1233
1232 1233 1231
1232 1233 1232
1232 1233 1233
1233 1231 1231
1233 1231 1232
1233 1231 1233
1233 1232 1231
1233 1232 1232
1233 1232 1233
1233 1233 1231
1233 1233 1232
1233 1233 1233
*/

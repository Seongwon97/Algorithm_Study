package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연산자 끼워넣기 (DFS)
// https://www.acmicpc.net/problem/14888
public class Ch13_dfs_bfs_Q19 {

    private static int maxValue = Integer.MIN_VALUE;
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int[] number = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            int[] remainSigns = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                remainSigns[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> signs = new ArrayList<>();
            dfs(number, 0, remainSigns, signs);

            System.out.println(maxValue);
            System.out.println(minValue);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dfs(int[] number, int depth, int[] remainSigns, List<Integer> signs) {
        if (depth == (number.length - 1)) {
            int result = number[0];
            for (int i = 0; i < signs.size(); i++) {
                if (signs.get(i) == 0) {
                    result += number[i + 1];
                } else if (signs.get(i) == 1) {
                    result -= number[i + 1];
                } else if (signs.get(i) == 2) {
                    result *= number[i + 1];
                } else if (signs.get(i) == 3) {
                    result /= number[i + 1];
                }
            }

            minValue = Math.min(minValue, result);
            maxValue = Math.max(maxValue, result);
        }

        for (int i = 0; i < remainSigns.length; i++) {
            if (remainSigns[i] > 0) {
                remainSigns[i]--;
                signs.add(i);
                dfs(number, depth + 1, remainSigns, signs);

                signs.remove(signs.size() - 1);
                remainSigns[i]++;
            }
        }
    }
}

/*
Input
2
5 6
0 0 1 0

Output
30
30
---
Input
3
3 4 5
1 0 1 0

Output
35
17
---
Input
6
1 2 3 4 5 6
2 1 1 1

Output
54
-24
 */

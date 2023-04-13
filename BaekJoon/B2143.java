package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2143
// 두 배열의 합
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] cumulativeSumOfA = new int[N + 1];
        int[] cumulativeSumOfB = new int[M + 1];

        for (int i = 0; i < N; i++) {
            cumulativeSumOfA[i + 1] = cumulativeSumOfA[i] + A[i];
        }

        for (int i = 0; i < M; i++) {
            cumulativeSumOfB[i + 1] = cumulativeSumOfB[i] + B[i];
        }

        List<Integer> sumOfSubArrayOfA = new ArrayList<>();
        List<Integer> sumOfSubArrayOfB = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                sumOfSubArrayOfA.add(cumulativeSumOfA[i] - cumulativeSumOfA[j - 1]);
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= i; j++) {
                sumOfSubArrayOfB.add(cumulativeSumOfB[i] - cumulativeSumOfB[j - 1]);
            }
        }

        Collections.sort(sumOfSubArrayOfA);
        Collections.sort(sumOfSubArrayOfB);

        System.out.println(getCount(sumOfSubArrayOfA, sumOfSubArrayOfB, T));
    }

    public static long getCount(List<Integer> listA, List<Integer> listB, int T) {
        int pa = 0;
        int pb = listB.size() - 1;
        long count = 0;

        while (pa < listA.size() && pb >= 0) {
            long sum = listA.get(pa) + listB.get(pb);

            if (sum == T) {
                int a = listA.get(pa);
                int b = listB.get(pb);
                long aCnt = 0;
                long bCnt = 0;

                while (pa < listA.size() && listA.get(pa) == a) {
                    aCnt++;
                    pa++;
                }

                while (pb >= 0 && listB.get(pb) == b) {
                    bCnt++;
                    pb--;
                }

                count += aCnt * bCnt;
            } else if (sum < T) {
                pa++;
            } else if (sum > T) {
                pb--;
            }
        }

        return count;
    }
}
/*
Input
5
4
1 3 1 2
3
1 3 2

Output
7
---
Input
5
4
1 3 1 2
3
1 3 2

Output
7
*/


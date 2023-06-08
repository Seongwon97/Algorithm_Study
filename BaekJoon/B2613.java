package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2613
// 숫자구슬
// Parametric Search!!!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int lower = 0; // 구슬 합의 최소값
        int upper = 0; // 구슬 합의 최댓값
        int[] beads = new int[N];
        for (int i = 0; i < N; i++) {
            beads[i] = Integer.parseInt(st.nextToken());
            lower = Math.max(lower, beads[i]);
            upper += beads[i];
        }

        int maxBead = binarySearch(lower, upper, M, beads);

        StringBuilder sb = new StringBuilder();
        sb.append(maxBead).append("\n");

        int count = 0;
        int numOfBeads = 0;
        for (int i = 0; i < beads.length; i++) {
            numOfBeads += beads[i];
            if (numOfBeads > maxBead) {
                sb.append(count).append(" ");
                numOfBeads = beads[i];
                count = 1;
                M--;
            } else {
                count++;
            }

            if (M == N - i) {
                break;
            }
        }

        while (M > 0) {
            sb.append(count).append(" ");
            M--;
            count = 1;
        }

        System.out.println(sb);
    }

    private static int binarySearch(int lower, int upper, int M, int[] beads) {
        while (lower <= upper) {
            // mid는 구슬 합의 최댓값
            int mid = (lower + upper) / 2;

            int numOfGroups = findNumOfGroups(mid, beads);

            if (numOfGroups > M) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }

        return lower;
    }

    private static int findNumOfGroups(int mid, int[] beads) {
        int sum = 0;
        int numOfGroups = 1;

        for (int bead : beads) {
            sum += bead;
            if (sum > mid) {
                numOfGroups++;
                sum = bead;
            }
        }

        return numOfGroups;
    }
}
/*
Input
8 3
5 4 2 6 9 3 8 7

Output
17
4 2 2
---
Input
4 4
1 1 2 1

Output
2
1 1 1 1
*/

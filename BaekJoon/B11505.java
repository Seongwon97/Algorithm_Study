package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11505
// 구간 곱 구하기
public class Main {
    static int MOD = 1_000_000_007;
    static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        int k = (int) (Math.ceil(Math.log(N) / Math.log(2)) + 1);
        int size = (int) Math.pow(2, k);
        tree = new long[size];

        init(1, N, 1);

        for (int i = 0; i < K + M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, N, 1, b, c);
                arr[b] = c;
            } else {
                System.out.println(mul(1, N, 1, b, (int) c));
            }
        }
    }

    private static long init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    // start, end: 시작과 끝 인덱스
    // left, right: 합을 구하고자 하는 범위
    private static long mul(int start, int end, int node, int left, int right) {
        // 범위 밖에 있는 경우
        if (left > end || right < start) {
            return 1;
        }
        // 범위 안에 있는 경우
        if (left <= start && end <= right) {
            return tree[node];
        }
        // 그렇지 않다면 두 부분으로 나누어 합을 구하기
        int mid = (start + end) / 2;
        return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    // start, end: 시작과 끝 인덱스
    // idx: 구간 값을 수정할 idx
    // val: 수정할 값
    private static long update(int start, int end, int node, int idx, long val) {
        // 범위 밖에 있는 경우
        if (idx < start || idx > end) {
            return tree[node];
        }
        if (start == end) {
            return tree[node] = val;
        }

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % MOD;
    }
}
/*
Input
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5

Output
240
48
---
Input
5 2 2
1
2
3
4
5
1 3 0
2 2 5
1 3 6
2 2 5

Output
0
240
*/

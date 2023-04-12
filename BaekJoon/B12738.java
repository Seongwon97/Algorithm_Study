package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/12738
// 가장 긴 증가하는 부분 수열 3
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            int number = arr[i];
            int start = 1;
            int end = list.size() - 1;

            if (number > list.get(end)) {
                list.add(number);
            } else {
                while (start < end) {
                    int mid = (start + end) / 2;

                    if (list.get(mid) >= number) {
                        end = mid;
                    } else {
                        start = mid + 1;
                    }
                }
                list.set(end, number);
            }
        }

        int answer = list.size() - 1;

        System.out.println(answer);
    }
}
/*
Input
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0

Output
4
*/

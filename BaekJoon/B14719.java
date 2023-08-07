package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14719
// 빗물
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] info = new int[W];
        for (int i = 0; i < W; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i < W - 1; i++) { //인덱스 별 모이는 빗물. 첫, 마지막 제외
            int current = info[i];
            int left = current;
            int right = current;

            for (int j = i - 1; j >= 0; j--) {
                left = Math.max(info[j], left);

            }
            for (int j = i + 1; j < W; j++) {
                right = Math.max(info[j], right);
            }

            if (Math.min(left, right) > current) {
                answer += Math.min(left, right) - current;
            }
        }

        System.out.println(answer);
    }
}
/*
Input
4 4
3 0 1 4

Output
5
*/

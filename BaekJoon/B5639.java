package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5639
// 이진 검색 트리
public class Main {
    private static final int MAX_SIZE = 10_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[MAX_SIZE + 1];
        int index = 0;
        String str;
        while (true) {
            str = br.readLine();
            if (str == null || str.equals("")) {
                break;
            }
            input[index++] = Integer.parseInt(str);
        }
        postOrder(0, index - 1, input);
    }

    private static void postOrder(int start, int end, int[] input) {
        if (start > end) {
            return;
        }
        int value = input[start];
        int index = start + 1;
        while (index <= end) {
            if (input[index] < value) {
                index++;
            } else {
                break;
            }
        }
        postOrder(start + 1, index - 1, input);
        postOrder(index, end, input);
        System.out.println(value);
    }
}
/*
Input
50
30
24
5
28
45
98
52
60

Output
5
28
24
45
30
60
52
98
50
*/

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/11286
// 절댓값 힙
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Number> numbers = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (numbers.isEmpty()) {
                    System.out.println(0);
                } else {
                    Number number = numbers.poll();
                    System.out.println(number.value);
                }
            } else {
                numbers.add(new Number(input));
            }
        }
    }

    static class Number implements Comparable<Number> {
        int value;

        public Number(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Number o) {
            if (Math.abs(this.value) != Math.abs(o.value)) {
                return Math.abs(this.value) - Math.abs(o.value);
            }
            return this.value - o.value;
        }
    }
}
/*
Input
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0

Output
-1
1
0
-1
-1
1
1
-2
2
0
*/

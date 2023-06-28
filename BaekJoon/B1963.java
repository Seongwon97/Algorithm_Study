package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1963
// 소수 경로
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[10000];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < 10000; i++) {
            if (!isPrime[i]) {
                continue;
            }

            for (int j = i * 2; j < 10000; j += i) {
                isPrime[j] = false;
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int result = findWeight(isPrime, start, end);
            if (result == -1) {
                sb.append("Impossible");
            } else {
                sb.append(result);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findWeight(boolean[] isPrime, int start, int end) {
        boolean[] isVisited = new boolean[10000];
        Queue<Temp> queue = new LinkedList<>();
        queue.add(new Temp(start, 0));
        while (!queue.isEmpty()) {
            Temp polled = queue.poll();
            if (polled.number == end) {
                return polled.weight;
            }

            for (int i = 0; i < 4; i++) {
                int temp =
                        (int) (polled.number / Math.pow(10, i + 1)) * (int) Math.pow(10, i + 1) + (int) (polled.number
                                % Math.pow(10, i));
                for (int j = 0; j < 10; j++) {
                    if (i == 3 && j == 0) {
                        continue;
                    }
                    int addNumber = (int) (j * Math.pow(10, i));
                    if (!isPrime[temp + addNumber] || isVisited[temp + addNumber]) {
                        continue;
                    }

                    isVisited[temp + addNumber] = true;
                    queue.add(new Temp(temp + addNumber, polled.weight + 1));
                }
            }
        }

        return -1;
    }

    static class Temp {
        int number;
        int weight;

        public Temp(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }
}
/*
Input
3
1033 8179
1373 8017
1033 1033

Output
6
7
0
*/

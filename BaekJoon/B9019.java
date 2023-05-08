package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/9019
// DSLR
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Queue<Number> queue = new LinkedList<>();
            queue.add(new Number(A, new ArrayList<>()));
            boolean[] visited = new boolean[10_000];
            while (!queue.isEmpty()) {
                Number polled = queue.poll();
                if (polled.value == B) {
                    addResult(polled.previousCommand, sb);
                    break;
                }

                // D
                int D = (polled.value * 2) % 10_000;
                if (!visited[D]) {
                    visited[D] = true;
                    queue.add(new Number(D, polled.previousCommand, 'D'));
                }

                // S
                int S = polled.value - 1;
                if (S == -1) {
                    S = 9999;
                }

                if (!visited[S]) {
                    visited[S] = true;
                    queue.add(new Number(S, polled.previousCommand, 'S'));
                }

                // L
                int L = (polled.value % 1_000) * 10 + (polled.value / 1_000);
                if (!visited[L]) {
                    visited[L] = true;
                    queue.add(new Number(L, polled.previousCommand, 'L'));
                }

                // R
                int R = (polled.value / 10) + (polled.value % 10) * 1_000;
                if (!visited[R]) {
                    visited[R] = true;
                    queue.add(new Number(R, polled.previousCommand, 'R'));
                }
            }
        }
        System.out.println(sb);
    }

    private static void addResult(List<Character> commands, StringBuilder sb) {
        for (Character command : commands) {
            sb.append(command);
        }
        sb.append("\n");
    }

    static class Number {
        int value;
        List<Character> previousCommand;

        public Number(int value, List<Character> previousCommand) {
            this.value = value;
            this.previousCommand = previousCommand;
        }

        public Number(int value, List<Character> previousCommand, char newCommand) {
            this.value = value;
            this.previousCommand = new ArrayList<>();

            this.previousCommand.addAll(previousCommand);
            this.previousCommand.add(newCommand);
        }
    }
}
/*
Input
3
1234 3412
1000 1
1 16

Output
LL
L
DDDD
*/

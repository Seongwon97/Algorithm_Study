package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1062
// 가르침
public class Main {
    private static int N;
    private static int K;
    private static String[] words;
    private static boolean[] visited;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        if (K < 5) { // "anta", "tica"로 시작하고 끝나려면 acnti 5개의 문자가 최소한으로 필요
            System.out.println(0);
            return;
        } else if (K == 26) { // 모든 알파벳을 다 읽을 수 있는 경우
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int nextIdx, int numberOfLearnedLetters) {
        if (numberOfLearnedLetters == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean canRead = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (!visited[words[i].charAt(j) - 'a']) {
                        canRead = false;
                        break;
                    }
                }

                if (canRead) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }

        for (int i = nextIdx; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(i, numberOfLearnedLetters + 1);
                visited[i] = false;
            }
        }
    }
}
/*
Input
4 4
3 0 1 4

Output
5
*/

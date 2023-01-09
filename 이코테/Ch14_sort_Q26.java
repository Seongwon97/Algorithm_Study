package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 카드 정렬하기
// https://www.acmicpc.net/problem/1715
public class Ch14_sort_Q26 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                queue.offer(Integer.parseInt(br.readLine()));
            }

            int answer = 0;
            while (queue.size() > 1) {
                int deck1 = queue.poll();
                int deck2 = queue.poll();

                int sum = deck1 + deck2;
                answer += sum;
                queue.offer(sum);
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
3
10
20
40

Output
100
 */

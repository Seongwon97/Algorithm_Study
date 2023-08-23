package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회전하는 큐
// https://www.acmicpc.net/problem/1021
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int count = 0;
        int[] temp = new int[M];
        for (int i = 0; i < M; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> q = new LinkedList<>();


        for (int i = 1; i <= N; i++)
            q.add(i);

        for (int i = 0; i < M; i++) {

            if (check(temp[i], q)) {
                while (temp[i] != q.get(0)) {
                    q.addLast(q.pollFirst());
                    count++;
                }
            } else {
                while (temp[i] != q.get(0)) {
                    q.addFirst(q.pollLast());
                    count++;
                }
            }

            q.poll();
        }
        System.out.println(count);
    }

    public static boolean check(int a, LinkedList<Integer> q) {
        for (int i = 0; i <= q.size() / 2; i++) {
            if (a == q.get(i))
                return true;
        }
        return false;
    }
}
/*
Input
32 6
27 16 30 11 6 23

Output
59
*/

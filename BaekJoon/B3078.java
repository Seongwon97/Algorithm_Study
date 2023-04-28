package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3078
// 좋은 친구
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[] students = new String[N];
        for (int i = 0; i < N; i++) {
            students[i] = br.readLine();
        }

        long answer = 0;
        Queue<String> queue = new LinkedList<>();
        int[] nameLength = new int[21];
        for (int i = N - 1; i >= 0; i--) {
            int currentLength = students[i].length();
            answer += nameLength[currentLength];
            nameLength[currentLength]++;
            queue.add(students[i]);

            if (queue.size() > K) {
                String polledStudent = queue.poll();
                nameLength[polledStudent.length()]--;
            }
        }

        System.out.println(answer);
    }
}
/*
Input
4 2
IVA
IVO
ANA
TOM

Output
5
---
Input
6 3
CYNTHIA
LLOYD
STEVIE
KEVIN
MALCOLM
DABNEY

Output
2
*/

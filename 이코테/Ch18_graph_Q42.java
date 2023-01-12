package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 탑승구
public class Ch18_graph_Q42 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int G = Integer.parseInt(br.readLine()); // 탐승구의 수
            int P = Integer.parseInt(br.readLine()); // 비행기의 수
            int[] parents = new int[G + 1];
            for (int i = 0; i < G + 1; i++) {
                parents[i] = i;
            }

            int[] gateInfos = new int[P];
            for (int i = 0; i < P; i++) {
                gateInfos[i] = Integer.parseInt(br.readLine());
            }

            int result = 0;
            for (int gateInfo : gateInfos) {
                int data = findParent(parents, gateInfo); // 현재 비행기의 탑승구 루트 확인
                if (data == 0) { // 루트가 0이면 종료
                    break;
                }
                unionParent(parents, data, data - 1); // 루트가 0이 아닐 경우 탑승구 합치기
                result++;
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int findParent(int[] parents, int a) {
        if (parents[a] != a) {
            parents[a] = findParent(parents, parents[a]);
        }
        return parents[a];
    }

    private static void unionParent(int[] parents, int a, int b) {
        int parentA = findParent(parents, a);
        int parentB = findParent(parents, b);

        if (parentA < parentB) {
            parents[b] = parentA;
        } else {
            parents[a] = parentB;
        }
    }
}

/*
Input
4
3
4
1
1

Output
2
---
Input
4
6
2
2
3
3
4
4

Output
3
*/

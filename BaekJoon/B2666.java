package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2666
// 벽장문의 이동
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] openedDoors = new int[2];
        openedDoors[0] = Integer.parseInt(st.nextToken());
        openedDoors[1] = Integer.parseInt(st.nextToken());

        int lengthOfClosetsToUse = Integer.parseInt(br.readLine());
        int[] closetsToUse = new int[lengthOfClosetsToUse];
        for (int i = 0; i < lengthOfClosetsToUse; i++) {
            closetsToUse[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(openedDoors[0], openedDoors[1], 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.nextIdx == lengthOfClosetsToUse) {
                answer = Math.min(answer, node.weight);
                continue;
            }

            int nextCloset = closetsToUse[node.nextIdx];
            queue.add(new Node(nextCloset, node.position2, node.weight + Math.abs(nextCloset - node.position1), node.nextIdx + 1));
            queue.add(new Node(node.position1, nextCloset, node.weight + Math.abs(nextCloset - node.position2), node.nextIdx + 1));
        }

        System.out.println(answer);
    }

    static class Node {
        int position1;
        int position2;
        int weight;
        int nextIdx;

        public Node(int position1, int position2, int weight, int nextIdx) {
            this.position1 = position1;
            this.position2 = position2;
            this.weight = weight;
            this.nextIdx = nextIdx;
        }
    }
}
/*
Input
7
2 5
4
3
1
6
5

Output
5
*/

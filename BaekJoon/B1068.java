package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1068
// 트리
public class Main {

    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int root = -1;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < N; i++) {
            tree.put(i, new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree.get(parent).add(i);
            }
        }

        int toBeRemove = Integer.parseInt(br.readLine());

        if (root != toBeRemove) {
            dfs(tree, root, toBeRemove);
        }

        System.out.println(answer);
    }

    private static void dfs(Map<Integer, List<Integer>> tree, int current, int toBeRemove) {
        List<Integer> childNodes = tree.get(current);
        if (childNodes.isEmpty() || (childNodes.size() == 1 && childNodes.get(0) == toBeRemove)) {
            answer++;
            return;
        }

        for (int childNode : childNodes) {
            if (childNode == toBeRemove) {
                continue;
            }
            dfs(tree, childNode, toBeRemove);
        }
    }
}
/*
Input
5
-1 0 0 1 1
2

Output
2
---
Input
5
-1 0 0 1 1
1

Output
1
---
Input
5
-1 0 0 1 1
0

Output
0
---
Input
9
-1 0 0 2 2 4 4 6 6
4

Output
2
*/

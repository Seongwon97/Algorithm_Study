package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/14267
// 회사 문화 1
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<Integer, Employee> employees = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            employees.put(i, new Employee());
        }

        int root = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                employees.get(parent).subordinates.add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int ei = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            employees.get(ei).weight += w;
        }

        relayPraise(employees, root);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(employees.get(i).weight).append(" ");
        }

        System.out.println(sb);
    }

    private static void relayPraise(Map<Integer, Employee> employees, int parent) {
        int parentWeight = employees.get(parent).weight;
        for (int subordinate : employees.get(parent).subordinates) {
            employees.get(subordinate).weight += parentWeight;
            relayPraise(employees, subordinate);
        }
    }

    static class Employee {
        List<Integer> subordinates;
        int weight;

        public Employee() {
            this.subordinates = new ArrayList<>();
            this.weight = 0;
        }
    }
}
/*
Input
5 3
-1 1 2 3 4
2 2
3 4
5 6

Output
0 2 6 6 12
*/

package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

// https://www.acmicpc.net/problem/7662
// 이중 우선순위 큐
public class Main {
    /*
    기능
    1. 데이터 삽입
    2. 데이터 삭제 -> 우선순위가 높은 것 삭제, 우선순위가 낮은 것 삭제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int Q = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> nums = new TreeMap<>();
            for (int i = 0; i < Q; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int val = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    nums.put(val, nums.getOrDefault(val, 0) + 1);
                } else {
                    if (nums.isEmpty()) {
                        continue;
                    }
                    int n; // 삭제해야할 Index
                    if (val == 1) {
                        n = nums.lastKey();
                    } else {
                        n = nums.firstKey();
                    }

                    if (nums.put(n, nums.get(n) - 1) == 1) {
                        nums.remove(n);
                    }
                }
            }
            if (nums.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(nums.lastKey() + " " + nums.firstKey());
            }
        }
    }
}
/*
Input
2
7
I 16
I -5643
D -1
D 1
D 1
I 123
D -1
9
I -45
I 653
D 1
I -642
I 45
I 97
D 1
D -1
I 333

Output
EMPTY
333 -45
*/

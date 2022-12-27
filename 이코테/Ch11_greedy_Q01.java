package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 모험가 길드 (Greedy)
public class Ch11_greedy_Q01 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] adventurers = new int[N];
            for (int i = 0; i < N; i++) {
                adventurers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(adventurers);

            int numOfGroups = 0;
            for (int i = 0; i < adventurers.length; i++) {
                if (adventurers[i] > (adventurers.length - i)) {
                    break;
                }
                numOfGroups++;
                i+= adventurers[i];
            }

            System.out.println(numOfGroups);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Input
5
2 3 1 2 2

Output
2
 */

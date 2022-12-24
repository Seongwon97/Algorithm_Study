package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 시각
public class Ch4_implementation_ex2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    StringBuilder sb = new StringBuilder()
                            .append(i)
                            .append(j)
                            .append(k);
                    int index = sb.indexOf("3");
                    if (index != -1) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

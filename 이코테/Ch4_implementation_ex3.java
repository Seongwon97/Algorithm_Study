package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 왕실의 나이트
public class Ch4_implementation_ex3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int y = input.charAt(0) - 96;
        int x = Integer.parseInt(input.substring(1));

        int[] dx = {-1, 1, 2, 2, -2, -2, -1, 1};
        int[] dy = {2, 2, 1, -1, 1, -1, -2, -2};

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx <= 0 || nx > 8 || ny <= 0 || ny > 8) {
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}

package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 상하좌우
public class Ch4_implementation_ex1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Character> commands = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            commands.add(st.nextToken().charAt(0));
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] commandType = {'L', 'R', 'U', 'D'};

        int x = 1;
        int y = 1;
        for (char command : commands) {
            int nx = 0;
            int ny = 0;
            for (int i = 0; i < commandType.length; i++) {
                if (command == commandType[i]) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }

            if (nx <= 0 || nx > n || ny <= 0 || ny > n ) {
                continue;
            }
            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}

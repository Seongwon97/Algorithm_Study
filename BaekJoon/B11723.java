package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11723
// 집합
/*
add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
all: S를 {1, 2, ..., 20} 으로 바꾼다.
empty: S를 공집합으로 바꾼다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int S = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num;

            switch (command) {
                case "add":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    S = S | (1 << num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    S = S & ~(1 << num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    int check = S & (1 << num);
                    sb.append((check == 0) ? 0 : 1).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken()) - 1;
                    S = S ^ (1 << num);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
                default:
                    throw new IllegalArgumentException("잘못된 명령입니다.");
            }
        }
        System.out.println(sb);
    }
}
/*
Input
26
add 1
add 2
check 1
check 2
check 3
remove 2
check 1
check 2
toggle 3
check 1
check 2
check 3
check 4
all
check 10
check 20
toggle 10
remove 20
check 10
check 20
empty
check 1
toggle 1
check 1
toggle 1
check 1

Output
1
1
0
1
0
1
0
1
0
1
1
0
0
0
1
0
*/


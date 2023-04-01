import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// K번째 수
// https://www.acmicpc.net/problem/1300
// 풀이 https://st-lab.tistory.com/281
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long low = 1;
        long high = k;

        while (low < high) {
            long mid = (low + high) / 2;
            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (k <= count) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}
/*
Input
3
7

Output
6
*/

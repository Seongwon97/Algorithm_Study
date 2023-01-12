package chapter3_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정확한 순위
public class Ch17_shortest_distance_Q38 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[][] matrix = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                matrix[i][i] = true;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int lower = Integer.parseInt(st.nextToken());
                int higher = Integer.parseInt(st.nextToken());

                matrix[lower - 1][higher - 1] = true;
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = matrix[i][j] || (matrix[i][k] && matrix[k][j]);
                    }
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true; // 다른 인원과 비교 가능한지 비교
                for (int j = 0; j < N; j++) {
                    if (!matrix[i][j] && !matrix[j][i]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    answer++;
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
Input
6 6
1 5
3 4
4 2
4 6
5 2
5 4

Output
1
*/

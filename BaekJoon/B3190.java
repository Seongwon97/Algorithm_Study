package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 뱀 (구현)
// https://www.acmicpc.net/problem/3190
public class B3190 {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            int K = Integer.parseInt(br.readLine());

            int[][] snakePosition = new int[N][N];
            for (int[] row : snakePosition) {
                Arrays.fill(row, -1);
            }
            boolean[][] hasApple = new boolean[N][N];
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                hasApple[r - 1][c - 1] = true;
            }

            int L = Integer.parseInt(br.readLine());
            int[] times = new int[L];
            String[] positions = new String[L];
            for (int i = 0; i < L; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                times[i] = Integer.parseInt(st.nextToken());
                positions[i] = st.nextToken();
            }

            snakePosition[0][0] = 0;
            int currentCommand = 0; // 방향 정보 변환 정보의 순서
            boolean hasCommand = true;
            int currentTime = 0; // 진행된 시간
            int snakeLength = 1; // 뱀의 길이
            int currentY = 0;
            int currentX = 0;
            // 오른쪽 아래쪽 왼쪽 위쪽 방향으로 이동
            int[] dy = {0, 1, 0, -1};
            int[] dx = {1, 0, -1, 0};
            // 초기 상태는 오른쪽을 보고 있음
            int currentDirection = 0;
            while (true) {
                currentTime++;
                currentX += dx[currentDirection];
                currentY += dy[currentDirection];
                // 보드 밖으로 이동할 경우 끝!
                if (currentX < 0 || currentX >= N || currentY < 0 || currentY >= N) {
                    break;
                }
                if (hasApple[currentY][currentX]) {
                    snakeLength++;
                    hasApple[currentY][currentX] = false;
                }
                // 자신의 몸과 부딪혔을 때!
                if (snakePosition[currentY][currentX] >= (currentTime - snakeLength)
                        && snakePosition[currentY][currentX] != -1) {
                    break;
                }
                snakePosition[currentY][currentX] = currentTime;

                if (hasCommand && currentTime == times[currentCommand]) {
                    currentCommand++;
                    if (currentCommand == L) {
                        hasCommand = false;
                    }
                    currentDirection = getCurrentDirection(currentDirection, positions[currentCommand - 1]);
                }
            }

            System.out.println(currentTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getCurrentDirection(int currentDirection, String position) {
        if (position.equals("D")) {
            if (currentDirection == 3) {
                return 0;
            }
            return currentDirection + 1;
        } else {
            if (currentDirection == 0) {
                return 3;
            }
            return currentDirection - 1;
        }
    }
}

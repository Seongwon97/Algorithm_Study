package chapter3_greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

// 블록 이동하기 (BFS)
// https://school.programmers.co.kr/learn/courses/30/lessons/60063
public class Ch13_dfs_bfs_Q22 {

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int endPosition = board.length - 1;

        Set<DronePosition> visited = new HashSet<>();
        Queue<DronePosition> queue = new LinkedList<>();
        DronePosition initPosition = new DronePosition(0, 0, 0, 1, 0);
        queue.offer(initPosition);
        visited.add(initPosition);
        while (!queue.isEmpty()) {
            DronePosition polledPosition = queue.poll();
            if ((polledPosition.x1 == endPosition && polledPosition.y1 == endPosition) ||
                    (polledPosition.x2 == endPosition && polledPosition.y2 == endPosition)) {
                return polledPosition.cost;
            }
            for (DronePosition position : getNextPosition(polledPosition, board)) {
                if (!visited.contains(position)) {
                    queue.offer(position);
                    visited.add(position);
                }
            }
        }
        return 0;
    }

    private static List<DronePosition> getNextPosition(DronePosition position, int[][] board) {
        List<DronePosition> availablePositions = new ArrayList<>();
        for (int i = 0; i < 4; i++) { // 상하좌우 이동
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, -1, 0, 1};

            int nx1 = position.x1 + dx[i];
            int ny1 = position.y1 + dy[i];
            int nx2 = position.x2 + dx[i];
            int ny2 = position.y2 + dy[i];
            if (isValidPosition(board, nx1, ny1) && isValidPosition(board, nx2, ny2)) {
                DronePosition newPosition = new DronePosition(nx1, ny1, nx2, ny2, position.cost + 1);
                availablePositions.add(newPosition);
            }
        }

        int[] directions = {-1, 1};
        if (position.x1 == position.x2) { // 로봇이 가로로 위치한 경우
            for (int i : directions) { // 위로 회전 or 아래로 회전
                if (isValidPosition(board, position.x1 + i, position.y1) &&
                        isValidPosition(board, position.x2 + i, position.y2)) {
                    availablePositions.add(new DronePosition(position.x1, position.y1, position.x1 + i, position.y1, position.cost + 1));
                    availablePositions.add(new DronePosition(position.x2, position.y2, position.x2 + i, position.y2, position.cost + 1));
                }
            }
        } else if (position.y1 == position.y2) {
            for (int i : directions) { // 위로 회전 or 아래로 회전
                if (isValidPosition(board, position.x1, position.y1 + i) &&
                        isValidPosition(board, position.x2, position.y2 + i)) {
                    availablePositions.add(new DronePosition(position.x1, position.y1, position.x1, position.y1 + i, position.cost + 1));
                    availablePositions.add(new DronePosition(position.x2, position.y2, position.x2, position.y2 + i, position.cost + 1));
                }
            }
        }

        return availablePositions;
    }

    private static boolean isValidPosition(int[][] board, int x, int y) {
        int N = board.length;
        return x >= 0 && x < N && y >= 0 && y < N && board[x][y] != 1;
    }

    private static class DronePosition {
        int x1;
        int y1;
        int x2;
        int y2;
        int cost;

        public DronePosition(int x1, int y1, int x2, int y2, int cost) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.cost = cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DronePosition dronePosition = (DronePosition) o;
            return (x1 == dronePosition.x1 && y1 == dronePosition.y1 && x2 == dronePosition.x2
                    && y2 == dronePosition.y2)
                    || (x1 == dronePosition.x2 && y1 == dronePosition.y2 && x2 == dronePosition.x1
                    && y2 == dronePosition.y1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
}

/*

 */

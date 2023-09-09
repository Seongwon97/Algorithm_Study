// https://school.programmers.co.kr/learn/courses/15009/lessons/121687
class Solution {
	public int[] solution(String command) {
		int[] dy = {1, 0, -1, 0};
		int[] dx = {0, 1, 0, -1};

		int direction = 0;
		int y = 0;
		int x = 0;

		for (int i = 0; i < command.length(); i++) {
			char c = command.charAt(i);
			if (c == 'R' || c == 'L') {
				direction = changeDirection(direction, c);
				continue;
			}

			if (c == 'G') {
				y += dy[direction];
				x += dx[direction];
			} else {
				y -= dy[direction];
				x -= dx[direction];
			}

		}

		int[] answer = {x, y};
		return answer;
	}

	private int changeDirection(int direction, char command) {
		if (command == 'R') {
			direction++;
		} else {
			direction--;
		}

		if (direction == 4) {
			direction = 0;
		} else if (direction == -1) {
			direction = 3;
		}

		return direction;
	}
}

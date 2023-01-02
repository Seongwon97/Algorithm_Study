package chapter3_greedy;

// 자물쇠와 열쇠 (구현)
// https://school.programmers.co.kr/learn/courses/30/lessons/60059
public class Ch12_implementation_Q10 {

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        boolean answer = solution(key, lock);
        System.out.println(answer);
    }

    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        int nl = lock.length;
        int[][] newLock = new int[nl * 3][nl * 3];

        for (int i = 0; i < nl; i++) {
            for (int j = 0; j < nl; j++) {
                newLock[i + nl][j + nl] = lock[i][j];
            }
        }

        for (int i = 0; i < 4; i++) {
            key = rocateMatrix(key);
            for (int x = 0; x < nl * 2; x++) {
                for (int y = 0; y < nl * 2; y++) {
                    addKey(key, newLock, x, y);
                    if (isMatch(newLock)) {
                        answer = true;
                        break;
                    }
                    minusKey(key, newLock, x, y);
                }
            }
        }

        return answer;
    }

    public static int[][] rocateMatrix(int[][] key) {
        int nk = key.length;

        int[][] newKey = new int[nk][nk];
        for (int i = 0; i < nk; i++) {
            for (int j = 0; j < nk; j++) {
                newKey[j][nk - i - 1] = key[i][j];
            }
        }
        return newKey;
    }

    public static boolean isMatch(int[][] lock) {
        int nl = lock.length / 3;

        for (int i = nl; i < nl * 2; i++) {
            for (int j = nl; j < nl * 2; j++) {
                if (lock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void addKey(int[][] key, int[][] newLock, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newLock[x + i][y + j] += key[i][j];
            }
        }
    }

    private static void minusKey(int[][] key, int[][] newLock, int x, int y) {
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                newLock[x + i][y + j] -= key[i][j];
            }
        }
    }
}
/*
입력값 〉	[[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
기댓값 〉	true
 */

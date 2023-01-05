package chapter3_greedy;

// 외벽 점검 (구현)
// https://school.programmers.co.kr/learn/courses/30/lessons/60062
public class Ch12_implementation_Q14 {

    private int answer = 0;

    public int solution(int n, int[] weak, int[] dist) {
        int[] fullWeak = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            fullWeak[i] = weak[i];
        }
        for (int i = weak.length; i < fullWeak.length; i++) {
            fullWeak[i] = weak[i - weak.length] + n;
        }

        answer = dist.length + 1;
        for (int start = 0; start < weak.length; start++) {
            permutation(dist, 0, fullWeak, start);
        }

        if (answer > dist.length) {
            return -1;
        }
        return answer;
    }

    private void permutation(int[] dist, int depth, int[] weak, int start) {
        if (depth == dist.length) {
            int count = 1;
            int position = weak[start] + dist[count - 1];
            for (int i = start; i < start + (weak.length / 2); i++) {
                if (position < weak[i]) {
                    count++;
                    if (count > dist.length) {
                        break;
                    }
                    position = weak[i] + dist[count - 1];
                }
            }
            answer = Math.min(answer, count);
            return;
        }

        for (int i = depth; i < dist.length; i++) {
            swap(dist, depth, i);
            permutation(dist, depth + 1, weak, start);
            swap(dist, depth, i);
        }
    }

    private void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
/*
입력값 〉	5, [[1, 0, 0, 1], [1, 1, 1, 1], [2, 1, 0, 1], [2, 2, 1, 1], [5, 0, 0, 1], [5, 1, 0, 1], [4, 2, 1, 1], [3, 2, 1, 1]]
기댓값 〉	[[1, 0, 0], [1, 1, 1], [2, 1, 0], [2, 2, 1], [3, 2, 1], [4, 2, 1], [5, 0, 0], [5, 1, 0]]
 */

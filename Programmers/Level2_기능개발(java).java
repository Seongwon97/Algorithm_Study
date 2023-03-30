import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainTime = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);

            if (!queue.isEmpty() && queue.peek() < remainTime) {
                answer.add(queue.size());
                queue.clear();
            }
            queue.add(remainTime);
        }
        answer.add(queue.size());

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

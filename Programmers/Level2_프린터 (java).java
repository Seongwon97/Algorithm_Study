import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        int[] numOfPriorities = new int[11];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            numOfPriorities[priorities[i]]++;
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            int polledPriority = priorities[polled];
            if (hasMorePriority(numOfPriorities, polledPriority)) {
                queue.add(polled);
            } else {
                count++;
                if (polled == location) {
                    break;
                }
                numOfPriorities[priorities[polled]]--;
            }
        }

        return count;
    }

    private boolean hasMorePriority(int[] numOfPriorities, int polledPriority) {
        for (int i = polledPriority + 1; i < 11; i++) {
            if (numOfPriorities[i] > 0) {
                return true;
            }
        }
        return false;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int temp1;
        int temp2;
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i: scoville)
            queue.offer(i);
        
        while (queue.peek() < K) {
            temp1 = queue.poll();
            temp2 = queue.poll();
            queue.offer(temp1 + (temp2*2));
            answer++;
        }
        
        if(queue.peek() < K)
            return -1;
   
        return answer;
    }
}
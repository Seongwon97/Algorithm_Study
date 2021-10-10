import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0; // 순서 count
        int loc = location; // 출력하고자하는 값의 현재 위치를 나타내는 변수
        int first; // List의 첫번째 값을 저장할 변수
        int max;
                
        List<Integer> jobList = new LinkedList<>();
        for (int i: priorities)
            jobList.add(i);
        
        max = Collections.max(jobList);
        
        while (true) {
            first = jobList.remove(0);   
            if (first >= max) {
                if (!jobList.isEmpty())
                    max = Collections.max(jobList);
                answer++;
                if (loc == 0) break;
                else loc--;
            }
            else {
                jobList.add(first);
                if (loc == 0) 
                    loc = (jobList.size()-1);
                else loc--;
            }              
        }
        return answer;
    }
}
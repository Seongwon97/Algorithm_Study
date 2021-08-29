class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();        
        int share = n;
        int remain;
        
        while (share != 0) {
            remain = share % 3;
            share = share / 3;
            
            if(remain == 0){
                remain = 4;
                share -= 1;
            }
            answer.append(remain);        
        }       
        return answer.reverse().toString();
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i=1; i<= n; i++){
            int result = 0;
            int adder = i;
            
            while (result <= n){
                result += adder;
                if (result == n){
                    answer++;
                    break;
                } 
                else adder++;
            }
        }
        return answer;
    }
}
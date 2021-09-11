import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        // k진수로 변경
        StringBuilder str = new StringBuilder();
        int numer = n;
        while(numer > 0){
            str.append(numer%k);
            numer/=k;
        }
        str.reverse();
        
        int index = str.indexOf("0");
        
        
        
        // 0이 없고 숫자가 한개인데 소수인 경우
        if (index == -1) {
            int num = Integer.parseInt(str.toString());
            if(checkPrime(num)){
                answer++;
            }
        }
        
        
        Boolean p0check= false; // 0P0 확인을 위한 변수
        while (index != -1){
            
            // P0확인
            Boolean isExist = false;
            int finalPrime = 0;
            for (int i = index-1; i >= 0; i--){
                int num  = Integer.parseInt(str.substring(i, index));
                if(checkPrime(num)){
                    // 앞에서 0P로 끝난게 있으면 i로 끝나는 수는 해당 X 
                    if (p0check && i==0){
                        p0check = false;
                        break;
                    }
                    isExist = true;
                    finalPrime = num;
                }
            }
            if (isExist){
                answer++;
            } 
            
            // 0P확인
            isExist = false;
            finalPrime = 0;
            str.delete(0, index+1);
            
            index = str.indexOf("0");
            
            // 문장 뒤에 0이 없는 경우
            if (index == -1) {
                for (int i = 1; i < str.length()+1; i++){
                    int num  = Integer.parseInt(str.substring(0, i));
                    if(checkPrime(num)){
                        finalPrime = num;
                        p0check = true;
                        isExist = true;
                    }
                }
                if (isExist){
                answer++;
                } 
                break;
            }
            
            for (int i = 1; i < index; i++){
                int num  = Integer.parseInt(str.substring(0, i));
                if(checkPrime(num)){
                    finalPrime = num;
                    p0check = true;
                    isExist = true;
                }
            }
            if (isExist){
                answer++;
            } 
        }
        
        return answer;
        
    }
    
    
    public boolean checkPrime(int num){
        if (num == 1) 
            return false;
        
        for (int i=2; i< num; i++){
            if(num%i==0)
                return false;
        }
        
        return true;
    }
}
import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        Boolean isExist = false;
        int finalPrime = 0;
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
                System.out.println(num);
            }
        }
        
        
        else {
            isExist = false;
            finalPrime = 0;
            
            // 0P확인   
            for (int i = index-1; i >= 0; i--){
                int num  = Integer.parseInt(str.substring(i, index));
                if(checkPrime(num)){
                    // 앞에서 0P로 끝난게 있으면 i로 끝나는 수는 해당 X 
                	System.out.println(num);
                    isExist = true;
                    finalPrime = num;
                    
                }
            }
            if (isExist) answer++;
            System.out.println("1answer : "+answer);
            
            isExist = false;
            finalPrime = 0;
            str.delete(0, index+1);
            
            
            // P0확인
            index = str.lastIndexOf("0");
            System.out.println("lastIndexOf : "+index);
            if (index != -1) {
                for (int i = index+2; i < str.length()+1; i++){
                    int num  = Integer.parseInt(str.substring(index+1, i));
                    if(checkPrime(num)){
                    	System.out.println(num);
                        finalPrime = num;
                        isExist = true;
                        
                    }
                }
                if (isExist) answer++;
                System.out.println("2answer : "+answer);
            }
            str.delete(index+1, str.length());
            
         // 0P0확인
            index = str.indexOf("0");
            while (index != -1){
            	//System.out.println("index: "+ index);
            	//System.out.println("str: "+ str.toString());
                if (index == 0){
                    str.delete(0, index+1);
                    index = str.indexOf("0");
                    continue;
                }
                int num  = Integer.parseInt(str.substring(0, index));
                //System.out.println("num: "+ num);
                if(checkPrime(num)){
                	System.out.println(num);
                    answer++;
                    System.out.println("3answer : "+answer);
                }
                str.delete(0, index+1);
                index = str.indexOf("0");
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
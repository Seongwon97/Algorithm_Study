import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int count = 0; // Array에 넣은 값들의 수
        int temp;
        int result = 0; // 점수별 결과
        ArrayList<Integer> resultArr = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        StringBuilder sb = new StringBuilder(dartResult);

        
        while(sb.length() != 0) {
            // S,D,T가 들어있는 index알아내기
            temp = sb.indexOf("S");
            if (temp != -1) index.add(temp);
            temp = sb.indexOf("D");
            if (temp != -1) index.add(temp);
            temp = sb.indexOf("T");
            if (temp != -1) index.add(temp);
            int minIndex = Collections.min(index);
            char score = sb.charAt(minIndex);
            index.clear();
            
            // SDT앞에 있는 숫자 확보
            int number = Integer.parseInt(sb.substring(0, minIndex));
            
            // SDT에 따른 연산
            if(score == 'S') {
                result = number;
            } 
            else if(score == 'D') {
                result = number*number;
            }       
            else if(score == 'T') {
                result = number*number*number;
            }
            
            if (sb.length() > (minIndex+1)) {
                if (sb.charAt(minIndex+1) == '*'){
                    if (count == 0){
                        result *= 2;
                    } 
                    else {
                    	result *= 2;
                        resultArr.set(count-1, resultArr.get(count-1)*2);
                    }
                    sb.delete(0, minIndex+2);
                }
                else if (sb.charAt(minIndex+1) == '#'){
                    result *= (-1);
                    sb.delete(0, minIndex+2);
                } 
                else sb.delete(0, minIndex+1);
            }
            else sb.delete(0, minIndex+1);

            resultArr.add(result);
            count++;  
            
        }
        
        for (int i=0; i<resultArr.size(); i++) {
            answer += resultArr.get(i);
        }
        
        return answer;
    }
}
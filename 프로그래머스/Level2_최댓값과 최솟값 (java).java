import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] strArr = s.split(" ");
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(intArr);
        
        answer = intArr[0] +" " + intArr[intArr.length -1];
        
        return answer;
    }
}
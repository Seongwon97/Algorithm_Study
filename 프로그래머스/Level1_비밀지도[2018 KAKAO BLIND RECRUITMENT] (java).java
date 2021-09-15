import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] strArr1 = new String[n];
        strArr1 = changeBinary(n, arr1);
        
        String[] strArr2 = new String[n];
        strArr2 = changeBinary(n, arr2);
        
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for (int j=0;j<n;j++){
                if (strArr1[i].charAt(j) =='1' || strArr2[i].charAt(j) =='1')
                    sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        
        return answer;
    }
    
    
    public String[] changeBinary(int n, int[] arr1) {
        String[] binaryStr = new String[n];
        for (int i = 0; i < n; i++) {
            String binary = Integer.toBinaryString(arr1[i]);
            if(binary.length() < n) {
                StringBuilder sb = new StringBuilder(binary);
                while (sb.length() < n){
                    sb.insert(0, '0');
                }
                binaryStr[i] = sb.toString();   
            }
            else binaryStr[i] = binary;  
        }
        return binaryStr;
    }
}
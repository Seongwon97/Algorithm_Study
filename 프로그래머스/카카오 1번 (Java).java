import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int userNum = id_list.length; // User의 수를 저장
        int count = 0; // 사용자들을 User map에 저장하기 위해 사용되는 임시 변수
        int[] answer = new int[userNum];
        
        // User의 id number를 저장할 HashMap
        HashMap<String, Integer> user = new HashMap<>();
        
        // 신고 내용을 HashMap으로 정리
        HashMap<String, boolean[]> declare = new HashMap<>(); 
        
        
        // user, declare map에 초기 값, 유저값들 추가
        for (String s: id_list){
            user.put(s, count);
            count++;
            
            boolean[] booleanArr = new boolean[userNum];
            declare.put(s, booleanArr);
        }
        
        // 신고내용을 반영
        for (String s: report){          
            String[] sSplit = s.split(" ");
            boolean[] temp = declare.get(sSplit[0]);
            temp[user.get(sSplit[1])] = true;
            declare.put(sSplit[0], temp);
        }
        
        
        int[] reportResult = new int[userNum]; // 신고 들어온 회수의 총 합을 저장하는 배열
        // 신고 회수를 반영
        for (String s: declare.keySet()){
            boolean[] temp = declare.get(s);
            for(int i=0; i< userNum; i++){
                if (temp[i]){
                    reportResult[i]++;
                }
            } 
        }
        
        boolean[] isLimit = new boolean[userNum];
        // 신고회수가 k보다 많은지 체크후 제한할지 결정
        for (int i=0; i< userNum; i++) {
            if (reportResult[i] >= k)
                isLimit[i] = true;

        }
        
        // 제한된 user를 신고한 사람에게 알림
        for (String s: declare.keySet()){
            boolean[] temp = declare.get(s);
            for(int i=0; i< userNum; i++){
                if(isLimit[i] && temp[i])
                    answer[user.get(s)]++;
            } 
        }
            
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String s) {
        // 문자열 앞뒤 {{, }}를 자르고 },{ 을 -로 변환
        String str = s.substring(2, s.length()-2).replace("},{", "-");
        
        // -단위로 string 나누기
        String[] strArr = str.split("-");
        
        // String의 길이를 비교하여 정렬하기
        Arrays.sort(strArr, new Comparator<String>(){
            public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
            }
        });
        
        
        ArrayList<Integer> answer = new ArrayList<>();
        

        for (String sList: strArr){
            // 각각의 문자열을 ,로 나누고 값들을 int로 변환
            String[] temp = sList.split(",");   
            int[] temp2 = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();

            
            // 배열 길이가 1이면 바로 List에 값을 넣고 아니라면 
            //for문을 돌며 값이 List에 있는지 확인 후 없으면 추가
            if (temp2.length==1)
                answer.add(temp2[0]);
            else{
                for (int i=0; i< temp2.length; i++){
                    if (!answer.contains(temp2[i]))
                        answer.add(temp2[i]);
                }
            } 
        }
        
        return answer;
    }
}
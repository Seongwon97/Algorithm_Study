class Solution {
    public String solution(String new_id) {
        
        
        // 1단계. 모든 문자 소문자로 변환
        String str = new_id.toLowerCase();
        
        // 2단계. 알파벳, 숫자, -_.아니면 삭제
        str = str.replaceAll("[^a-z0-9-_.]","");
        
        
        // 3단계. (.)이 2개 이상이면 하나로 변경
        str = str.replaceAll("[.]{2,}",".");

        // 4단계. (.)으로 시작하거나 끝나면 (.)삭제
        str = str.replaceAll("^[.]","");
        str = str.replaceAll("[.]$","");
        
        // 5단계. 문자열이 비어있으면 a추가
        if (str.isEmpty())
            str = "a";
        
        // 6단계. string이 15자리 이상이면 뒤에 문자열 자르기
        if (str.length() > 15)
            str = str.replace(str.substring(15, str.length()), "");
        str = str.replaceAll("[.]$","");
                              
        // 7단계. string이 2자 이하면 맨 뒤의 문자로 3자리로 늘리기
        while (str.length() < 3){
            str += str.charAt(str.length()-1);
        }
        
        System.out.println(str);

        return str;
    }
}
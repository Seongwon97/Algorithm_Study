class Solution {
    public String solution(String s) {
        String answer;
        int length = s.length();

        if (length % 2 == 0) {
            int startIndex = (length / 2) - 1;
            answer = s.substring(startIndex, startIndex + 2);
        } else {
            int startIndex = length / 2;
            answer = s.substring(startIndex, startIndex + 1);
        }

        return answer;
    }
}

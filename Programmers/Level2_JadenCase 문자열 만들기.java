import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean isPreviousBlank = true;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (isPreviousBlank) {
                if ('a' <= currentChar && currentChar <= 'z') {
                    answer.append((char) (currentChar + ('A' - 'a')));
                    isPreviousBlank = false;
                    continue;
                }
            }

            if (currentChar == ' ') {
                isPreviousBlank = true;
            } else {
                isPreviousBlank = false;
            }

            answer.append(currentChar);
        }

        return answer.toString();
    }
}

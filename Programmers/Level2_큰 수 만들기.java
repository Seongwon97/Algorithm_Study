class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int startIndex = 0;
        while (k > 0 && startIndex < number.length()) {
            int idx = getNextSaveIndex(number, k, startIndex);
            answer.append(number.charAt(idx));
            k -= (idx - startIndex);
            startIndex = idx + 1;
        }

        if (k == 0) {
            answer.append(number.substring(startIndex));
        } else {
            while (k > 0) {
                answer.deleteCharAt(answer.length() - 1);
                k--;
            }
        }

        return answer.toString();
    }

    private int getNextSaveIndex(String number, int k, int startIndex) {
        int maxIndex = startIndex;
        char maxNum = number.charAt(maxIndex);
        for (int i = startIndex + 1; i <= startIndex + k && i < number.length(); i++) {
            if (maxNum < number.charAt(i)) {
                maxIndex = i;
                maxNum = number.charAt(i);
            }
        }
        return maxIndex;
    }
}

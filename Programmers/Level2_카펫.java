class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) {
                continue;
            }
            int width = yellow / i;
            int height = i;

            int totalBrown = (width + height) * 2 + 4;
            if (totalBrown == brown) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        return answer;
    }
}

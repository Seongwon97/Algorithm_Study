class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        int move = len - 1;
        for (int i = 0; i < len; i++) {
            answer += changeCharacter(name.charAt(i));

            int idx = i + 1;
            // 다음 글자에 A가 있는 경우, index 증가
            while (idx < len && name.charAt(idx) == 'A') {
                idx++;
            }
            move = Math.min(move, Math.min((i * 2) + len - idx, (len - idx) * 2 + i));
        }
        answer += move;

        return answer;
    }

    private int changeCharacter(char target) {
        return Math.min(target - 'A', 1 + 'Z' - target);
    }
}

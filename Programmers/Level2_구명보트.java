import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        boolean[] isBoarded = new boolean[people.length];
        int startIndex = 0;
        int endIndex = people.length - 1;

        while (startIndex < endIndex) {
            if (people[startIndex] + people[endIndex] <= limit) {
                isBoarded[startIndex] = true;
                isBoarded[endIndex] = true;
                startIndex++;
                endIndex--;
                answer++;
            } else {
                endIndex--;
            }
        }

        for (boolean b : isBoarded) {
            if (!b) {
                answer++;
            }
        }

        return answer;
    }
}

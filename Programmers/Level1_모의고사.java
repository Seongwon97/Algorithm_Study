import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] randomNumber = new int[][]{{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        List<Integer> highestCorrectAnswer = new ArrayList<>();
        int numOfMaxCorrectAnswer = 0;

        for (int i = 0; i < 3; i++) {
            int numOfRandomNumber = randomNumber[i].length;
            int numOfCorrectAnswer = 0;
            for (int j = 0; j < answers.length; j++) {
                if (answers[j] == randomNumber[i][j % numOfRandomNumber]) {
                    numOfCorrectAnswer++;
                }
            }

            if (numOfCorrectAnswer == numOfMaxCorrectAnswer) {
                highestCorrectAnswer.add(i + 1);
            } else if (numOfCorrectAnswer > numOfMaxCorrectAnswer) {
                numOfMaxCorrectAnswer = numOfCorrectAnswer;
                highestCorrectAnswer.clear();
                highestCorrectAnswer.add(i + 1);
            }
        }

        return highestCorrectAnswer
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}

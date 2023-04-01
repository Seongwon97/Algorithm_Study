import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] depth = new int[words.length];

        Queue<Integer> queue = new LinkedList<>();
        for (int index : findAvailableToChangeWords(begin, words)) {
            if (words[index].equals(target)) {
                return 1;
            }
            queue.add(index);
            depth[index] = 1;
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for (int index : findAvailableToChangeWords(words[p], words)) {
                if (depth[index] != 0) {
                    continue;
                }

                if (words[index].equals(target)) {
                    return depth[p] + 1;
                }
                queue.add(index);
                depth[index] = depth[p] + 1;
            }
        }

        return 0;
    }

    private List<Integer> findAvailableToChangeWords(String word, String[] words) {
        List<Integer> availableToChangeWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (isSimilarWords(word, words[i])) {
                availableToChangeWords.add(i);
            }
        }

        return availableToChangeWords;
    }

    private boolean isSimilarWords(String word1, String word2) {
        int differentCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentCount++;
            }
        }

        return differentCount == 1;
    }
}

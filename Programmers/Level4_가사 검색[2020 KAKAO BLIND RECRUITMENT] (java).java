import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 가사 검색
// https://school.programmers.co.kr/learn/courses/30/lessons/60060
public class Level4 {

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] solution = solution(words, queries);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        Map<Integer, List<String>> reversedWordsByLength = new HashMap<>();

        for (String word : words) {
            int length = word.length();
            if (!wordsByLength.containsKey(length)) {
                wordsByLength.put(length, new ArrayList<>());
                reversedWordsByLength.put(length, new ArrayList<>());
            }

            wordsByLength.get(length).add(word);
            reversedWordsByLength.get(length).add(reverseWord(word));
        }

        for (int key : wordsByLength.keySet()) {
            Collections.sort(wordsByLength.get(key));
            Collections.sort(reversedWordsByLength.get(key));
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryLength = queries[i].length();
            if (queries[i].charAt(0) != '?') {
                answer[i] = findNumOfMatchedWords(wordsByLength.getOrDefault(queryLength, new ArrayList<>()),
                        queries[i]);
            } else {
                answer[i] = findNumOfMatchedWords(reversedWordsByLength.getOrDefault(queryLength, new ArrayList<>()),
                        reverseWord(queries[i]));
            }
        }
        return answer;
    }

    public static String reverseWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    private static int findNumOfMatchedWords(List<String> words, String query) {
        int startIndex = findStartIndex(words, query);
        int endIndex = findLastIndex(words, query);

        if (startIndex == -1 || endIndex == -1) {
            return 0;
        }
        return endIndex - startIndex + 1;
    }

    private static int findStartIndex(List<String> words, String query) {
        String queryKeyword = findQueryKeyword(query);

        int result = -1;
        int start = 0;
        int end = words.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == 0 && words.get(mid).startsWith(queryKeyword)) ||
                    (mid > 0 && !words.get(mid - 1).startsWith(queryKeyword) && words.get(mid).startsWith(queryKeyword))) {
                result = mid;
                break;
            } else if (words.get(mid).compareTo(queryKeyword) >= 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int findLastIndex(List<String> words, String query) {
        String queryKeyword = findQueryKeyword(query);

        int result = -1;
        int start = 0;
        int end = words.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((mid == words.size() - 1 && words.get(mid).startsWith(queryKeyword)) ||
                    (mid < words.size() - 1 && !words.get(mid + 1).startsWith(queryKeyword) && words.get(mid).startsWith(queryKeyword))) {
                result = mid;
                break;
            } else if (words.get(mid).compareTo(queryKeyword) < 0 || words.get(mid).startsWith(queryKeyword)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static String findQueryKeyword(String query) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '?') {
                break;
            }
            sb.append(query.charAt(i));
        }
        return sb.toString();
    }
}

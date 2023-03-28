import java.util.*;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, List<String>> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.putIfAbsent(cloth[1], new ArrayList<>());
            map.get(cloth[1]).add(cloth[0]);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            // 옷의 개수 + 아무것도 입지 않을 경우(1)
            int clothCase = map.get(key).size() + 1;
            answer *= clothCase;
        }
        // 아예 아무것도 입지 않을 경우 1 제외
        return answer - 1;
    }
}


import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participants, String[] completions) {
        Map<String, Integer> map = new HashMap<>();
        for (String participant : participants) {
            map.put(participant, map.getOrDefault(participant, 0) + 1);
        }

        for (String completion : completions) {
            Integer previous = map.get(completion);
            if (previous == 1) {
                map.remove(completion);
            } else {
                map.put(completion, previous - 1);
            }
        }

        return map.keySet().stream()
                .findFirst()
                .orElseThrow();
    }
}

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] courses) {
        List<String> result = new ArrayList<>();
        for (int course : courses) {
            Map<String, Integer> comb = new HashMap<>();
            for (String order : orders) {
                char[] orderChar = order.toCharArray();
                Arrays.sort(orderChar);
                if (order.length() >= course) {
                    for (int i = 0; i < order.length(); i++) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(orderChar[i]);
                        combination(comb, orderChar, sb, i + 1, course - 1);
                    }
                }
            }

            int max = 0;
            for (String key : comb.keySet()) {
                max = Math.max(max, comb.get(key));
            }

            for (String key : comb.keySet()) {
                if (max >= 2 && comb.get(key) == max) {
                    result.add(key);
                }
            }
        }

        Collections.sort(result);

        String[] answer = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    private void combination(Map<String, Integer> comb, char[] orderChar, StringBuilder sb, int start, int length) {
        if (length == 0) {
            String combResult = sb.toString();
            int count = comb.getOrDefault(combResult, 0);
            comb.put(combResult, count + 1);
            return;
        }

        for (int i = start; i < orderChar.length; i++) {
            sb.append(orderChar[i]);
            combination(comb, orderChar, sb, i + 1, length - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

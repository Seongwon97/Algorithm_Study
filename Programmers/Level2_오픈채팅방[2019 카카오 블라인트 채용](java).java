import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> userInfo = new HashMap<>();
        int numOfAnswer = 0;
        
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String order = st.nextToken();
            
            if (order.charAt(0) == 'E' || order.charAt(0) == 'C') {
                String id = st.nextToken();
            	String name = st.nextToken();
                userInfo.put(id, name);
                numOfAnswer++;
            }
        }
        
        ArrayList<String> result = new ArrayList<>();
        int idx = 0;
        for (String r : record) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(r);
            String order = st.nextToken();
            String id = st.nextToken();
            
            
            if (order.charAt(0) == 'E') {
                sb.append(userInfo.get(id));
                sb.append("님이 들어왔습니다.");
                result.add(sb.toString());
            }
            else if (order.charAt(0) == 'C') {
                continue;
            }
            else if (order.charAt(0) == 'L') {
                sb.append(userInfo.get(id));
                sb.append("님이 나갔습니다.");
                result.add(sb.toString());
            }
        }
        
        String[] answer = new String[result.size()];
        result.toArray(answer);
        return answer;
    }
}
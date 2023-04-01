import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// DFS
class Solution {

    static boolean isComplete = false;
    static List<String[]> route = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];

        dfs(tickets, new ArrayList<>(), "ICN");

        answer[0] = "ICN";
        for (int i = 0; i < route.size(); i++) {
            answer[i + 1] = route.get(i)[1];
        }

        return answer;
    }

    private void dfs(String[][] tickets, List<String[]> visited, String currentCountry) {
        if (isComplete) {
            return;
        }

        if (tickets.length == visited.size()) {
            route.addAll(visited);
            isComplete = true;
            return;
        }

        List<String[]> toVisit = Arrays.stream(tickets)
                .filter(o -> o[0].equals(currentCountry))
                .filter(o -> !visited.contains(o))
                .sorted(Comparator.comparing(o -> o[1]))
                .collect(Collectors.toList());

        for (String[] ticket : toVisit) {
            visited.add(ticket);
            dfs(tickets, visited, ticket[1]);
            visited.remove(ticket);
        }
    }
}

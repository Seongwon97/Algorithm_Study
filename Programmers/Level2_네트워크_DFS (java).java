class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            answer += dfs(i, computers, visited);
        }
        return answer;
    }

    public int dfs(int node, int[][] computers, boolean[] visited) {
        if (visited[node]) {
            return 0;
        }

        visited[node] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1) {
                dfs(i, computers, visited);
            }
        }
        return 1;
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Node>[] lists;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        lists = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            int distance = Integer.parseInt(stringTokenizer.nextToken());

            lists[node1].add(new Node(node2, distance));
            lists[node2].add(new Node(node1, distance));
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int destination = Integer.parseInt(stringTokenizer.nextToken());
            dfs(start, destination, -1, 0);
            bufferedWriter.write(result + System.lineSeparator());
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static void dfs(int start, int destination, int previous, int cost) {
        if (start == destination) {
            result = cost;
        }
        for (Node nextNode : lists[destination]) {
            if (nextNode.destination != previous) {
                dfs(start, nextNode.destination, destination, cost + nextNode.distance);
            }
        }
    }

    static class Node {
        int destination;
        int distance;

        public Node(int dest, int cost) {
            this.destination = dest;
            this.distance = cost;
        }
    }
}

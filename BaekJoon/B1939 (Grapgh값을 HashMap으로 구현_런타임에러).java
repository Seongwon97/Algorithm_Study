package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
	int nodeId; // 연결된 node의 id
	int weight;
	
	public Node(int nodeId, int weight) {
		this.nodeId = nodeId;
		this.weight = weight;
	}
}

public class B1939 {

	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<=n; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for (int i=0; i< m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
			
			max = Math.max(max, c);
			min = Math.min(min, c);
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int result = 0;
		while (min <= max) {
			int mid = (min + max)/2;
			if (bfs(start, end, n, mid)) {
				result = mid;
				min = mid+1;
			}
			else {
				max = mid -1;
			}
		}
		System.out.println(result);
		
		
	}

	static boolean bfs(int start, int end, int n, int mid) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		boolean[] visited = new boolean[n + 1];
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int x = queue.poll();
			if (x == end) return true;
			 
			ArrayList<Node> temp = list.get(x);
			
			for (Node node : temp) {
				if (!visited[node.nodeId] && node.weight >= mid) {
					visited[node.nodeId] = true;
					queue.offer(node.nodeId);
				}
			}
		}
		return false;
	}
}

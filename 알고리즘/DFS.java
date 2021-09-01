package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DFS {
	public static void main(String[] args) {
		HashMap<String, String[]> grapgh = new HashMap<>();
		String[][] nodeInfo = {{"B","C","D"},
				{"A", "E", "F"},
				{"A"},
				{"A"},
				{"B","G","H"},
				{"B"},
				{"E"},
				{"E"}};
		// nodeInfo에는 A~H순서대로 각 Node당 연결된 node들을 저장해둔다.
		// HashMap에는 put을 통해 바로 array를 넣을 수 없기에 이렇게 지정해야한다.
		
		grapgh.put("A", nodeInfo[0]);
		grapgh.put("B", nodeInfo[1]);
		grapgh.put("C", nodeInfo[2]);
		grapgh.put("D", nodeInfo[3]);
		grapgh.put("E", nodeInfo[4]);
		grapgh.put("F", nodeInfo[5]);
		grapgh.put("G", nodeInfo[6]);
		grapgh.put("H", nodeInfo[7]);
		
		System.out.println(bfs(grapgh, "A"));
	}
	
	public static List<String> bfs(HashMap<String, String[]> grapgh, String search){
		List<String> visited = new ArrayList<>();
		List<String> needVisit = new ArrayList<>();
		String node;
		
		needVisit.add(search);
		while (!needVisit.isEmpty()) {
			node = needVisit.remove(0);
			if (!visited.contains(node)) {
				visited.add(node);
				needVisit.addAll(Arrays.asList(grapgh.get(node)));
				// addAll은 list데이터를 넣어야하기에 array로 되어있는 
				// grapgh.get(node)의 값을 List로 변경 후 넣어준다.
			}
		}		
		return visited;	
	}
}

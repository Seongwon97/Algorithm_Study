package baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class B4195 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = Integer.parseInt(sc.nextLine());
		
		int connectNum;
		
		
		for (int i=0; i< testCaseNum; i++) {
			HashMap<String, String> map = new HashMap<>();
			connectNum = Integer.parseInt(sc.nextLine());
			for (int j=0; j< connectNum; j++) {
				
				// friend 이름 2개 받아서 나눠서 저장
				String connection = sc.nextLine();
				System.out.println(connection);
				String[] friend = new String[2];
				friend = connection.split(" ");
				
				
				// 각각의 parent를 자기 자신으로 설정
				for (String f: friend) {
					if (!map.containsKey(f))
						map.put(f, f);
				}
				
				String parentNode;
				// 두 node의 parent가 다르면 합친다.
				if (find(map, friend[0]) != find(map, friend[1])) {
					parentNode = union(map, friend[0], friend[1]);
				}
				else {
					parentNode = find(map, friend[0]);
				}
				
				int count=0;
				for (String s: map.keySet()) {
					if (find(map, map.get(s)).equals(parentNode))
						count++;
				}				
				System.out.println(count);	
			}
		}
		
	}
	public static String find(HashMap<String, String> map, String name) {
		if (map.get(name) != name) 
			map.put(name, find(map, map.get(name)));
		
		return map.get(name);
	}
	public static String union(HashMap<String, String> map, String name1, String name2) {
		// name1을 name2에 연결
		map.put(name1, map.get(name2));
		
		return map.get(name2);
	}

}

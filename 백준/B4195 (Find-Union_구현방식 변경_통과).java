package baekjoon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class B4195 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = Integer.parseInt(sc.nextLine());
		
		int connectNum;
		
		
		for (int i=0; i< testCaseNum; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int index = 0;
			connectNum = Integer.parseInt(sc.nextLine());
			
			int[] parent = new int[connectNum*2];
			int[] count = new int[connectNum*2];
			Arrays.fill(count, 1);
			Arrays.fill(parent, -1);
			for (int j=0; j< connectNum; j++) {
				
				// friend 이름 2개 받아서 나눠서 저장
				String connection = sc.nextLine();
				String[] friend = new String[2];
				friend = connection.split(" ");
				
				
				// 각각의 parent를 자기 자신으로 설정
				for (String f: friend) {
					if (!map.containsKey(f)) {
						map.put(f, index);
						parent[index] = index;
						index++;
					}				
				}		
				System.out.println(union(parent, count, map.get(friend[0]), map.get(friend[1])));
			}
		}
		
	}
	private static int find(int[] parent, int n) {
		if (parent[n] != n) 
			parent[n] = find(parent, parent[n]);
		
		return parent[n];
	}
	
	public static int union(int[] parent, int[] count, int n1, int n2) {
		// name1을 name2에 연결
		n1 = find(parent, n1);
		n2 = find(parent, n2);
		if (n1 != n2) {
			if(n1 < n2) {
				parent[n2] = n1;
				count[n1] += count[n2];
				return count[n1];
			}
			else {
				parent[n1] = n2;
				count[n2] += count[n1];
				return count[n2];
			}
		}
		return count[n1];

	}
}

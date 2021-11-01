package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B10775 {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		
		parent = new int[G+1];
		for (int i=0; i<=G; i++) parent[i] = i;
		
		int count = 0;
		for (int i=0; i<P; i++) {
			int g = Integer.parseInt(br.readLine());
			int parentGate = find(g);
			if (parentGate != 0) {
				count++;
				union(parentGate-1, parentGate);
			}
			else break;
		}
		System.out.println(count);
	}
	
	static int find(int g) {
		if (parent[g] == g) return g;
		return parent[g] = find(parent[g]);
	}
	
	static void union(int g1, int g2) {
		int p1 = find(g1);
		int p2 = find(g2);
		
		if (p1 < p2) parent[p2] = p1;
		else parent[p1] = p2;
	}
}

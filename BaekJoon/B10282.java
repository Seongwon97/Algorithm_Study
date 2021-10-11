package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B10282 {
	static int n; // 컴퓨터 개수
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for (int i=0; i<testCase; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수
			int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터
			
			// Computer추가
			ArrayList<Computer> computerList = new ArrayList<>();
			computerList.add(new Computer(0)); // Index를 맞추기 위해 추가
			for (int j=1; j<=n; j++) {
				computerList.add(new Computer(i));
			}
			
			// 의존성 추가 
			// b가 감염되면 s초후에 a가 감염
			for (int j=0; j<d; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());	
				computerList.get(b).dependency.put(a, s);
			}
			
			bw.write(dijkstra(computerList, c) +" ");
			
			// 가장 오래걸린 시간 탐색
			int maxTime = -1;
			for (int j=1; j<=n; j++) {
				if (maxTime < computerList.get(j).time && computerList.get(j).time != Integer.MAX_VALUE) {
					maxTime = computerList.get(j).time;
				}
			}
			bw.write(maxTime + "\n");
			
		}
		bw.flush();
		bw.close();
		
		
	}
	
	static int dijkstra (ArrayList<Computer> computerList, int c) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(c);
		computerList.get(c).time = 0;
		HashSet<Integer> set = new HashSet<>();
		
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			set.add(pop);
			
			for (int key : computerList.get(pop).dependency.keySet()) {
				// 연결된 node의 시간이 현재 node까지 온 시간+연결된 node까지 가는 시간보다 크다면 값을 변경
				if (computerList.get(key).time > computerList.get(pop).dependency.get(key) + computerList.get(pop).time) {	
					computerList.get(key).time = computerList.get(pop).dependency.get(key) + computerList.get(pop).time;
					queue.add(key);
				}
			}
		}
		return set.size();
	}

}

class Computer {
	int id;
	int time;
	HashMap<Integer, Integer> dependency;
	
	public Computer(int id) {
		this.id = id;
		this.time = Integer.MAX_VALUE;
		dependency = new HashMap<>();
	}

}
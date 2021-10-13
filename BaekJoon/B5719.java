package baeckjoon;

import java.io.*;
import java.util.*;

public class B5719 {
	static int[][] edgeInfo;
	static boolean[][] edgeExist;
	static int[] nodeArr;
	static int N;
	static List<Integer>[] parent;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		// 0 0이 나올때까지 test case탐색 및 수행
		String nextStr = br.readLine();
		while(!nextStr.equals("0 0")) {
			st = new StringTokenizer(nextStr);
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 출발, 도착지
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			
			// node들 추가
			parent = new ArrayList[N];
			nodeArr = new int[N];
			edgeInfo = new int[N][N];
			edgeExist = new boolean[N][N];
			for (int i=0; i<N; i++) {
				nodeArr[i] = Integer.MAX_VALUE;
				parent[i] = new ArrayList<>();
			}

			
//			// 역추적 하기 위해 이전의 Node탐색
//			previous = new int[N];
//			for (int i=0; i<N; i++) previous[i] = i;
			
			// edge추가
			for (int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				edgeInfo[U][V] = P;
				edgeExist[U][V] = true;
			}
//			System.out.println();
//			for (int i=0; i<N; i++) {
//				for (int j=0; j<N; j++) {
//					System.out.print(edgeExist[i][j]+" ");
//				}
//				System.out.println();
//			}
//			
//			System.out.println();
			

			
			dijkstra(S,D);
			backTracking(S,D);

			for (int i=0; i<N; i++) {
				nodeArr[i] = Integer.MAX_VALUE;
			}
			
//			for (int i=0; i<N; i++) {
//				for (int j=0; j<N; j++) {
//					System.out.print(edgeExist[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			bw.write(dijkstra(S,D) +"\n");
//			bw.write(dijkstra(S,D)+"\n");
//			bw.write("\n");

			nextStr = br.readLine();
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void backTracking(int start, int now) {
		if (now == start) return;
		for (int i: parent[now]) {
			if (edgeExist[i][now]) {
				edgeExist[i][now] = false;
				backTracking(start, i);
			}
		}
	}
	
	static int dijkstra(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		nodeArr[start] = 0;
		
		while (!queue.isEmpty()) {
			int pop = queue.poll();
			
			for (int i=0; i<N; i++) {
				if (nodeArr[i] == nodeArr[pop] + edgeInfo[pop][i] && edgeExist[pop][i])
					parent[i].add(pop);
				else if (edgeExist[pop][i] && nodeArr[i] > nodeArr[pop] + edgeInfo[pop][i]) {
					nodeArr[i] = nodeArr[pop] + edgeInfo[pop][i];
					queue.add(i);
					parent[i].clear();
					parent[i].add(pop);
				}
			}
		}
		return nodeArr[end] != Integer.MAX_VALUE? nodeArr[end]:-1;
	}
}

package baeckjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11000 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Lecture> lecList = new ArrayList<>();
		PriorityQueue<Integer> roomList = new PriorityQueue<>();
		StringTokenizer st;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			lecList.add(new Lecture(start, end));
		}
		Collections.sort(lecList);
		
		
		for (Lecture l: lecList) {
			if (roomList.isEmpty()) { // 강의실이 없으면 추가
				roomList.add(l.end);
				continue;
			}
			
			// 다음 강의가 시작하는 시간 이전에 
			// 강의가 끝나는 강의실이 있으면 해당 강의실에서 강의 시작
			if (roomList.peek() <= l.start) {
				roomList.poll();
			}
			roomList.add(l.end);
		}
		
		System.out.println(roomList.size());
	
	}
	
	static class Lecture implements Comparable<Lecture>{
		int start;
		int end;
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			if (this.start == o.start) return this.end < o.end ? -1:1;
			return this.start < o.start? -1:1;
		}
	}

}

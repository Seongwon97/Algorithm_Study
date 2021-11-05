package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1931 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Lecture> lectureList = new ArrayList<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			lectureList.add(new Lecture(start, end));
		}
		Collections.sort(lectureList);
		
		int endTime = 0;
		int count = 0;
		for (Lecture l: lectureList) {
			if (count == 0) {
				endTime = l.end;
				count++;
				continue;
			}

			
			if (endTime <= l.start) {
				endTime = l.end;
				count++;
			}
		}
		
		System.out.println(count);
	}

	static class Lecture implements Comparable<Lecture>{
		int start,end;
		
		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Lecture o) {
			// TODO Auto-generated method stub
			if (this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}

}

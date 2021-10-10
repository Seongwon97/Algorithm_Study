package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point o) {
		if (this.x == o.x) {
			return this.y < o.y? -1:1;
		}
		return this.x < o.x? -1:1;
	}
	
}


public class B11650 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// TODO Auto-generated method stub
		int num = Integer.parseInt(br.readLine());
		int x,y;
		
		ArrayList<Point> list = new ArrayList<>();
		
		for (int i=0; i<num; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			list.add(new Point(x,y));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<num;i++) {
			System.out.println(list.get(i).x+" "+ list.get(i).y);
		}
	}
}

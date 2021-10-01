package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int x,y;
		
		ArrayList<Point> list = new ArrayList<>();
		
		for (int i=0; i<num; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			list.add(new Point(x,y));
		}
		
		Collections.sort(list);
		
		for(int i=0;i<num;i++) {
			System.out.println(list.get(i).x+" "+ list.get(i).y);
		}
	}
}

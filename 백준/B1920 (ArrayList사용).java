package baekjoon;

import java.util.Scanner;
import java.util.*;

public class B1920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int nNum = sc.nextInt();
		ArrayList<Integer> nList = new ArrayList<>();
		for(int i = 0; i< nNum; i++) {
			nList.add(sc.nextInt());
		}
		
		int mNum = sc.nextInt();
		int[] mList = new int[mNum];
		for(int i = 0; i< mNum; i++) {
			mList[i] = sc.nextInt();
		}
		
		for(int i = 0; i< mNum; i++) {
			if (nList.contains(mList[i]))
				System.out.println(1);
			else System.out.println(0);
		}
	}

}

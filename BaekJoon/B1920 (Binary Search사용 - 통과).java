package baekjoon;

import java.util.Scanner;
import java.util.*;

public class B1920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int nNum = sc.nextInt();
		int[] nList = new int[nNum];
		for(int i = 0; i< nNum; i++) {
			nList[i] = sc.nextInt();
		}
		Arrays.sort(nList);
		
		int mNum = sc.nextInt();
		int[] mList = new int[mNum];
		for(int i = 0; i< mNum; i++) {
			mList[i] = sc.nextInt();
		}
		for(int i = 0; i< mNum; i++) {
			System.out.println(binarySearch(nList, mList[i]));
		}
		
	}
	
	public static int binarySearch(int[] nList, int searchNum) {
		int start = 0;
		int end = nList.length-1;
		int cursor = (start+end)/2;
		
		
		while (start <= end) {

			if (nList[cursor] == searchNum) return 1;
			else if (nList[cursor] < searchNum) {
				start = cursor+1;
			}
			else if (nList[cursor] > searchNum) {
				end = cursor-1;
			}
			cursor = (start+end)/2;
		}
		return 0;
	}
}

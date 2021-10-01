package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class B1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		int num = sc.nextInt();
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		// 각 자리를 나눠 List에 저장
		int remain;
		do {
			remain = num % 10;
			num = num / 10;
			arr.add(remain);
		}
		while (num > 0);
		
		Collections.sort(arr, Comparator.reverseOrder());
		
		for(int i:arr) {
			System.out.print(i);
		}
	}

}

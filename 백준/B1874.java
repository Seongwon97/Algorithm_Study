package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		
		for (int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		

		
		System.out.println(solution(n, arr));
		
	}
	
	public static String solution(int n, int[] arr) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		
		for (int i=0; i<n; i++) {
			// peek가 다음 출력 수 일때
			if (arr[i] >= count) {
				while (count < arr[i]) {
					stack.push(count+1);
					sb.append("+\n");
					count++;
				}
				stack.pop();
				sb.append("-\n");
			}
			else {
				if(arr[i] == stack.peek()) {
					stack.pop();
					sb.append("-\n");
				}
				else {
					return "No";
				}
				
			}
		}
		return sb.toString();
	}

}

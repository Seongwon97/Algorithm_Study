package baekjoon;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class B5397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = Integer.parseInt(sc.nextLine());
		
		String[] input = new String[testCaseNum];
		
		for (int i=0; i< testCaseNum; i++) {
			input[i] = sc.nextLine();
		}
		
		for (int i=0; i< testCaseNum; i++) {
			System.out.println(keyLogger(input[i]));
		}
		
	}
	
	public static String keyLogger(String input) {
		
		char[] keys = input.toCharArray();
		Stack<Character> pre = new Stack<>();
		Stack<Character> post = new Stack<>();
		
		for (int i=0; i< keys.length; i++) {
			if (keys[i] == '>') {
				if (!post.isEmpty())
					pre.add(post.pop());
			}
			else if (keys[i] == '<') {
				if (!pre.isEmpty())
					post.add(pre.pop());
			}
			else if(keys[i] == '-') {
				if (!pre.isEmpty())
					pre.pop();
			}
			else {
				pre.add(keys[i]);
			}

		}
		
		while(!post.isEmpty()) {
			pre.add(post.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!pre.isEmpty()) {
			sb.append(pre.pop());
		}

		return sb.reverse().toString();
	}

}

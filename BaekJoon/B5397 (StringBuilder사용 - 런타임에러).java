package baekjoon;

import java.util.Scanner;

public class B5397 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		
		String[] input = new String[testCaseNum];
		
		input[0] = sc.nextLine(); // 숫자 하나를 받고 다음 줄로 넘어가게 하기 위해서 임시로 한줄을 받음
		
		for (int i=0; i< testCaseNum; i++) {
			input[i] = sc.nextLine();
		}
		
		for (int i=0; i< testCaseNum; i++) {
			System.out.println(keyLogger(input[i]));
		}
		
	}
	
	public static String keyLogger(String input) {
		
		char[] keys = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int cursur = 0;
		for (int i=0; i< keys.length; i++) {
			if (keys[i] == '<') {
				if (cursur > 0)
					cursur--;
			}
			else if (keys[i] == '>') {
				if (cursur < sb.length())
					cursur++;
			}
			else if (keys[i] == '-') {
				if (sb.length() > 0 && cursur > 0) {
					sb.deleteCharAt(--cursur);
				}
			}
			else {
				sb.insert(cursur++, keys[i]);
			}
//			System.out.println("character: "+keys[i]);
//			System.out.println("Cursur: "+cursur);
//			System.out.println("Length: "+sb.length());
//			System.out.println("String: "+sb.toString()+"\n");
		}
		
		
		return sb.toString();
	}

}

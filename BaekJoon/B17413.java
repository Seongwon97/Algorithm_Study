package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17413 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder input = new StringBuilder(str);
		StringBuilder result = new StringBuilder();
		
		int startTag;
		int endTag;
		int space;
		
		while (input.length() > 0) {
			startTag = input.indexOf("<");
			endTag = input.indexOf(">");
			space =input.indexOf(" ");
			if (startTag == -1) startTag = 100000;
			if (endTag == -1) endTag = 100000;
			if (space == -1) space = 100000;
			
//			System.out.println(input.toString());
//			System.out.println(startTag+" "+endTag+" "+space);
			
			int endPosition;
			// 태그가 앞에 있는 경우
			if (startTag == 0) {
				result.append(input.subSequence(0, endTag+1));
				endPosition = endTag;
				input.delete(0, endPosition+1);
			}
			// 그 외의 경우
			else if (startTag == 100000 && endTag == 100000 && space == 100000) {
				result.append(input.reverse());
				input.delete(0, input.length());
			}
			else {
				endPosition = startTag < space? startTag:space;
				if (startTag < space) {
					endPosition = startTag;
					for (int i=endPosition-1; i>=0; i--) {
						result.append(input.charAt(i));
					}
					input.delete(0, endPosition);
				}
				else {
					endPosition = space;
					for (int i=endPosition-1; i>=0; i--) {
						result.append(input.charAt(i));
					}
					result.append(' ');
					input.delete(0, endPosition+1);
				}

			}
			// inputString에서 제거
//			if (space != 100000 && input.charAt(endPosition) == ' ') {
//				result.append(' ');
//				input.delete(0, endPosition+1);
//			}
//			else {
//				System.out.println(1);
//				input.delete(0, endPosition+1);
//			}
//			System.out.println(result.toString());
//			System.out.println(input.toString()+"\n");
//			Thread.sleep(300);

		}
		System.out.println(result.toString());
		
	}

}

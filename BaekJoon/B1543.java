package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1543 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(br.readLine());
		
		String findStr = br.readLine();
		int count = 0;
		int position;
		
		while (true) {
			position = sb.indexOf(findStr);
			if (position == -1) {
				break;
			}
			
			sb.delete(0, position+ findStr.length());
			count++;

		}
		
		System.out.println(count);

	}

}

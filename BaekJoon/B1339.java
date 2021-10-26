package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B1339 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] value = new int[26]; // 각 알파벳이 변경되는 값의 정보
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		
		// 문자열을 저장하며 가장 큰 길이 구하기
		int maxLen = 0;
		for (int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		// 각 단어들의 알파벳의 위치에 해당하는 값들 1, 10, 100.. 을 각각의 알파벳 배열의 값에 더해준다.
		for (int i=0; i<N; i++) {
			int temp = (int) Math.pow(10, words[i].length()-1);
			for (int j = 0; j<words[i].length(); j++) {
				int charIdx = words[i].charAt(j) - 'A';
				value[charIdx] += temp;
				temp /= 10;
			}
		}
		
		Arrays.sort(value);
			
		// 최종 합 구하기
		int num = 9;
		int result = 0;
		for (int i=25; i>=0; i--) {
			if (value[i] == 0) break;
			
			result += (value[i]*num);
			num--;
		}
		System.out.println(result);

	}

}

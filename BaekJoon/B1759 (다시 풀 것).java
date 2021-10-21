package algorithm;

import java.util.*;
import java.io.*;

public class B1759 {

	static int L;
	static int C;
	static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
	static char[] candidate;
	static StringBuilder result = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		candidate = new char[C];
		
		for (int i=0; i< C; i++) {
			candidate[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(candidate);
		
		for (int i=0; i< (C-3); i++) {
			StringBuilder cipher = new StringBuilder();
			cipher.append(candidate[i]);
			if (checkVowel(candidate[i])) dfs(1, i, 1, cipher.toString());
			else dfs(1, i, 0, cipher.toString());
		}
		
		System.out.println(result.toString());
		
	}
	static void dfs(int currentLen, int currentPointer, int numberOfVowels, String cipher) {
		if (currentLen == L) {
			if (1 <= numberOfVowels) {
				result.append(cipher+"\n");
			}
		}
		else if ((C-currentPointer-1) >= (L-currentLen)) {
			for (int i=(currentPointer+1); i< (C- L + currentLen + 1);i++) {
				if (checkVowel(candidate[i])) dfs(currentLen+1, i, numberOfVowels+1, cipher+candidate[i]);
				else dfs(currentLen+1, i, numberOfVowels, cipher+candidate[i]);
			}
		}
	}
	
	static boolean checkVowel(char c) {
		for (int i=0; i<5; i++) {
			if (c == vowels[i]) {
				return true;
			}
		}
		return false;
	}

}

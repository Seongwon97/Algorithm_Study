package algorithm;

import java.util.*;
import java.io.*;

public class B9663 {
	
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> currentCandidate = new ArrayList<>();
		nQueens(N, 0, currentCandidate);
		
		System.out.println(result);
		
	}
	static void nQueens(int n, int currentRow, List<Integer> currentCandidate) {
		if (currentRow == n) result++;
		else {
			for (int i=0; i<n; i++) {
				if (isAvailable(currentCandidate, i)) {
					currentCandidate.add(i);
					nQueens(n, currentRow+1, currentCandidate);
					currentCandidate.remove(currentRow);
				}
			}
		}
	}
	static boolean isAvailable(List<Integer> currentCandidate, int currentCol) {
		int currentRow = currentCandidate.size();
		for (int i=0; i<currentRow;i++) {
			if((currentCandidate.get(i)==currentCol) || (Math.abs(currentCandidate.get(i)-currentCol) == (currentRow - i)))
				return false;
		}
		return true;
	}

}

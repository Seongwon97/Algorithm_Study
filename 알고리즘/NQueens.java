package algorithm;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> finalResult = new ArrayList<>();
		List<Integer> currentCandidate = new ArrayList<>();
		dfs(4, 0, currentCandidate, finalResult);
		
		System.out.println(finalResult.toString());
	}
	public static boolean isAvailable(List<Integer> currentCandidate, int currentCol) {
		int currentRow = currentCandidate.size();
		for (int i=0; i<currentRow;i++) {
			if((currentCandidate.get(i)==currentCol) || (Math.abs(currentCandidate.get(i)-currentCol) == (currentRow - i)))
				return false;
		}
		return true;
	}
	
	public static void dfs(int n, int currentRow, List<Integer> currentCandidate, List<List<Integer>> finalResult) {
		if (currentRow == n) {
			List<Integer> temp = new ArrayList<>();
			for (int i : currentCandidate)
				temp.add(i);
			finalResult.add(temp);
			//System.out.println(finalResult.toString());
		}
		else {
			for (int i = 0; i < n; i++) {
				if (isAvailable(currentCandidate, i)) {
					currentCandidate.add(i);
					dfs(n, currentRow + 1, currentCandidate, finalResult);
					currentCandidate.remove(currentCandidate.size()-1);
				}
			}
		}
	}

}

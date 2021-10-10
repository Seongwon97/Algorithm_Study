package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = {3,8,43,20,9,15,61,54,13,94,2,10};
		
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		
		System.out.println(split(list).toString());
	}
	
	
	public static List<Integer> split(List<Integer> list){
		if (list.size() <= 1)
			return list;
		
		int listSize = list.size();
		List<Integer> left = list.subList(0, listSize/2);
		List<Integer> right = list.subList(listSize/2, listSize);
			
		left = split(left);
		right = split(right);
		return merge(left, right);
	}
	
	
	public static List<Integer> merge(List<Integer> left, List<Integer> right){
		// left, right가 둘 다 있을 때
		int leftPoint = 0;
		int rightPoint = 0;
		List<Integer> merged = new ArrayList<>();
		while(left.size() > leftPoint && right.size() > rightPoint) {
			if(left.get(leftPoint) < right.get(rightPoint)) {
				merged.add(left.get(leftPoint));
				leftPoint++;
			}
			else {
				merged.add(right.get(rightPoint));
				rightPoint++;
			}
		}
		
		// left가 없을 때
		while (left.size() > leftPoint) {
			merged.add(left.get(leftPoint));
			leftPoint++;
		}
		
		// right가 없을 때
		while (right.size() > rightPoint) {
			merged.add(right.get(rightPoint));
			rightPoint++;
		}
		
		return merged;
	}

}

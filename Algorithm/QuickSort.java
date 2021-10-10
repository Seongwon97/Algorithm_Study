package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

	public static void main(String[] args) {
		Integer[] arr = {3,8,43,20,9,15,61,54,13,94,2,10};
		
		List<Integer> list = new ArrayList<>(Arrays.asList(arr));
		
		System.out.println(quickSort(list).toString());
		
	}
	public static List<Integer> quickSort(List<Integer> arr) {
		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		
		// 크기가 1보다 작거나 같으면 그대로 반환
		if (arr.size() <= 1)
			return arr;
		
		int pivot = arr.remove(0);
		
		// data가 pivot보다 작으면 왼쪽으로, 크면 오른쪽으로 봔환
		for (int data: arr) {
			if (pivot > data)
				leftList.add(data);
			
			else rightList.add(data);
		}
		
		// 왼쪽, 오른쪽 list를 다시 quick sort한 후
		// 왼쪽 list + pivot + 오른쪽 list를 반환
		quickSort(leftList).add(pivot);
		leftList.addAll(quickSort(rightList));
		return leftList;
		
	}
	
	
}

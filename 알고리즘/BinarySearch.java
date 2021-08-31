package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<>();
		
		arr.add(34);
		
		for (int i=0;i<9;i++) {
			arr.add((int)(Math.random()*100));
		}
		arr.sort(null);
		System.out.println(arr);
		
		System.out.println(binarySearch(arr, 34));
		
	}
	
	public static int binarySearch(List<Integer> arr, int search) {
		// 데이터가 1개이고 그 데이터가 찾는 데이터면 True
		if (arr.size() == 1 && arr.get(0) == search)
			return 0;
		// 데이터가 1개인데 그 데이터가 찾는 데이터가 아니면 false
		if (arr.size() == 1 && arr.get(0) != search)
			return -1;
		// 데이터 자체가 없는 경우
		if (arr.size() == 0)
			return -1;
		
		int middle = arr.size()/2;
		if (arr.get(middle) == search)
			return middle;
		else {
			if (arr.get(middle) < search)
				return binarySearch(arr.subList(0, middle), search);
			else
				return binarySearch(arr.subList(middle, arr.size()), search);

		}
	}

}

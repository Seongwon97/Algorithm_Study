package algorithm;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {3,8,43,20,9,15,61,54,13,94,2,10};
		
		int temp = 0;
		for (int i = 1; i<arr.length ; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j-1]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				else break;
			}
		}
		
		for (int i = 0; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}	
	}
}

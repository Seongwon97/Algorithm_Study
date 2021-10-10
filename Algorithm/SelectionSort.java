package algorithm;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,8,43,2,9,15,61,54,3,94,2,10};
		
		int temp;
		int lowestIdx = 0;
		for (int i = 0; i<arr.length-1 ; i++) { // n-1번 수행하면 마지막은 자연스럽게 가장 큰 수가 위치하게 되어서 length -1번 수행한다.
			for (int j = i+1; j<arr.length; j++) { // 현재 위치인 i번째 이후의 data중에서 가장 작은 수를 찾는 것이기에 i+1부터 끝까지 수행
				if (arr[lowestIdx] > arr[j]) {
					lowestIdx = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[lowestIdx];
			arr[lowestIdx] = temp;
		}		
		for (int i = 0; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
}

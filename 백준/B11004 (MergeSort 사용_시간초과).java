package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B11004 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numberOfArray = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i < numberOfArray; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		list = split(list);

		System.out.println(list.get(k-1));

		
	}
	
	// Recursive하게 List를 절반으로 나눠주고 다시 병합해준다.
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
	
	
	
	// 2개의 list를 앞의 수를 계속 비교해가며 작은 수부터 merged list에 넣어 정렬하며 합친다.
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

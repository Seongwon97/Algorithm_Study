package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class B1302 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		
		int num = Integer.parseInt(br.readLine());
		
		String book;
		int max = -1;
		int bookCount;
		// HashMap에 책과 책의 수의 값을 추가
		for (int i=0; i< num; i++) {
			book = br.readLine();
			if (!map.containsKey(book)) 
				bookCount = 1;
			else 
				bookCount = map.get(book)+1;
			
			map.put(book, bookCount);
			if (max < bookCount)
				max = bookCount;	
		}
		
		// 가장 많은 수의 책들을 list에 추가
		ArrayList<String> list = new ArrayList<>();
		for (String s: map.keySet()) {
			if (map.get(s)== max)
				list.add(s);
		}
		
		// 사전순으로정렬
		Collections.sort(list);
		
		// 출력
		System.out.println(list.get(0));

	}
}

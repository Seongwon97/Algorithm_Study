package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;

public class B1946 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			ArrayList<Person> list = new ArrayList<>();
			
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int test1 = Integer.parseInt(st.nextToken());
				int test2 = Integer.parseInt(st.nextToken());
				
				list.add(new Person(test1, test2));
			}
			Collections.sort(list);
			
			
			int count = 1;
			int topTest2 = list.get(0).test2;
			for (int i=1; i<N; i++) {
				if (topTest2 > list.get(i).test2) {
					count++;
					topTest2 = list.get(i).test2;
				}
			}
			
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static class Person implements Comparable<Person> {
		int test1, test2;
		
		public Person(int test1, int test2) {
			this.test1 = test1;
			this.test2 = test2;
		}
		
		@Override
		public int compareTo(Person o) {
			return this.test1-o.test1;
		}
	}
	

}

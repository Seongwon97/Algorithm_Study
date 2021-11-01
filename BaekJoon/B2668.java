package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;


public class B2668 {

	static int N;
	static int[] arr;
	static boolean[] check;
	static int number;
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		check = new boolean[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i=1; i<=N; i++) {
			check[i] = true;
			number = i;
			dfs(i);
			check[i] = false;;
		}

		Collections.sort(list);
		bw.write(list.size()+ "\n");
		for(int i: list) bw.write(i+"\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void dfs(int idx) {
		if (arr[idx] == number) list.add(number);
		
		if (!check[arr[idx]]) {
			check[arr[idx]] = true;
			dfs(arr[idx]);
			check[arr[idx]] = false;
		}
		
	}

}

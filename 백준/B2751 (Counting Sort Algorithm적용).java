package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2751 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[2000001];
		int position;
		for (int i=0; i< num; i++) {
			position = Integer.parseInt(br.readLine())+1000000;
			arr[position] = true;
		}
		for (int i=0; i<2000001; i++) {
			if(arr[i]) bw.write(String.valueOf((i-1000000)+"\n"));
		}
		bw.flush();
		bw.close();
	}

}

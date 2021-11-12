package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int total = 0;
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			total += arr[i];
		}
		
		int M = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int result = 0;
		int left = 0;
		int right = arr[N-1];
        while (left <= right) {
            int mid = (left + right) / 2; //내야할 세금
            int sum = 0; // 모든 지방 세금 합
            
            for (int money : arr) {
                if (money >= mid) sum += mid; //내라는 세금 낼 수 있는 지방
                else sum += money; //못내는 지방은 가진 최대 돈만 냄
            }
            
            if (sum > M) { // 내라는 세금 보다 많은 경우 -> 세금을  줄여본다.
                right = mid - 1;
            } else { // 내라는 세금보다 적은 경우 -> 세금을 높여서 더 최고의 경우의 수를 찾는다.
                left = mid + 1;
               result = Math.max(result, mid);
            }
        }
        
        System.out.println(result);
	}

}

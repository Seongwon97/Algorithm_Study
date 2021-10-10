package algorithm;
// 피보나치 예시
// 동적 계획법은 상향식 접근법이다.
// 상향식 접근 법이라 기존의 recursive와 다르게 0번째부터 구한다.
public class DynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibo(10));
	}
	public static int fibo(int num) {
		int[] cache = new int[num+1]; 
		// ex) fibo 10을 한다면 fibo(0)부터 fibo(10)까지의 값이 모두 필요하기 때문
		
		cache[0] = 0;
		cache[1] = 1;
		
		for (int i=2; i< num+1; i++) {
			cache[i] = cache[i-1] + cache[i-2];
		}
		return cache[num];
	}

}

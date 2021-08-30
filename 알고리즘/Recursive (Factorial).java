package algorithm;

public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorial(5));
	}
	// 형태 1
	public static int factorial(int num) {
		if (num > 1) return num * factorial(num-1);
		else return num;
	}
	// 형태 2 (1과 조건을 반대로 하여 else문을 삭제한 것)
	public static int factorial2(int num) {
		if (num <= 1) return num;
		
		return num * factorial(num-1);
	}
	
}

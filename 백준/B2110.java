package baekjoon;

// Binary Search 
// 문제를 풀 때는 데이터의 개수를 보고 예를들어 10억개와 같이 많은 데이터에 대해 돌려야한다면
// 2진 탐색과 같은 자료구조를 사용하여 log x와 같은 시간복잡도를 만들도록 출제자가 출제했다는 것을 알아차려야한다!!!

// 이진탐색은 재귀적/반복적으로 풀 수 있는데 일반적으로 문제들에서는 반복적으로 푸는게 더 유리하다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B2110 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numOfHouse= Integer.parseInt(st.nextToken());
		int numOfWifi = Integer.parseInt(st.nextToken());
		
		int[] house = new int[numOfHouse];

		for (int i=0; i<numOfHouse; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);

		
		int result = 0;
		int start = 1; // 현재 가능한 최소 이동거리
		int end = house[numOfHouse-1] - house[0]; // 현재 이동가능한 최대 이동거리
		
		
		while (start <= end) {
			int midGap = (start+end)/2;
			int value = house[0];
			int count = 1;
			
			
			for (int i=1; i<numOfHouse; i++) {
				if (house[i] >= (value + midGap)) {
					value = house[i];
					count++;
				}
			}

			if (count >= numOfWifi) {
				start = midGap + 1;
				result = midGap;
			}
			else end = midGap-1;

		}
		System.out.println(result);
	}
}

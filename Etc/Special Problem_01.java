package baekjoon;
/* 
		현수의 컴퓨터는 멀티태스킹이 가능하다. 처리해야 할 작업이 N개 들어오면 현수의 컴퓨터는 작업을 1부터 N까지의 번호를 부여하고 처리를 다음과 같이 한다.
		
		1) 컴퓨터는 1번 작업부터 순서대로 1초씩 작업을 한다. 즉 각 작업을 1초만 작업하고 다음 작업을 하는 식이다.
		2) 마지막 번호의 작업을 1초 했으면 다시 1번 작업으로 가서 다시 1초씩 후속 처리를 한다.
		3) 처리가 끝난 작업은 작업 스케쥴에서 사라지고 새로운 작업은 들어오지 않는다.
		그런데 현수의 컴퓨터가 일을 시작한 지 K초 후에 정전이 되어 컴퓨터가 일시적으로 멈추었다. 전기가 들어오고 나서 현수의 컴퓨터가 몇 번 작업부터 다시 시작해야 하는지 알아내는 프로그램을 작성하세요.
		
		▣ 입력설명
		매개변수 times 배열에 처리해야 할 작업의 개수 N(1<=N<=200,000) 길이의 수열이 주어집니다. 수열의 원소는 각 작업을 처리하는데 걸리는 시간을 초단위로 해서 주어집니다. 한 작업을 처리하는데 필요한 시간은 100,000,000를 넘지 않는 자연수입니다.
		그 다음 정전이 발생한 시간 K(1<=K<=2 x 1013)가 주어진다.
		
		▣ 출력설명
		몇 번 작업부터 다시 시작해야 하는지 작업 번호를 반환합니다.
		만약 더 이상 처리할 작업이 없다면 -1를 반환합니다.
		
		▣ 매개변수 형식
		[1, 2, 3], 5
		
		▣ 반환값 형식
		3
		
		<입출력 설명>
		• 0~1초 동안에 1번 작업을 처리한다. 남은 시간은 [0, 2, 3] 이다.
		• 1~2초 동안 2번 작업을 처리한다. 남은 시간은 [0, 1, 3] 이다.
		• 2~3초 동안 3번 작업을 처리한다. 남은 시간은 [0, 1, 2] 이다.
		• 3~4초 동안 2번 작업을 처리한다(1번 작업은 다 처리했다). 남은 시간은 [0, 0, 2] 이다.
		• 4~5초 동안 3번 작업을 처리한다. 남은 시간은 [0, 0, 1] 이다.
		• 5초 후 정전이 발행했으므로 3번 작업을 해야 할 때 중단되었으므로, 전기가 돌아온 후로는 3번 작업부터 시작하면 된다.
*/


public class Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 4, 3};
		int error = 4;
		
		boolean[] isFinish = new boolean[input.length];
		
		int running = 0;
		int totalExe = 0;
		int finishCount = 0;
		while (true) {
			if (totalExe >= error) break; // 정전이 발생하면 break
			if (finishCount == input.length) break; // 모두 작업이 끝나도 break
			
			System.out.println("Run: "+(running+1));
			
			input[running]--;
			
			if (input[running] == 0) { // 수행 후 작업이 모두 끝나면 종료했다고 알림
				isFinish[running] = true;
				finishCount++;
			}
			
			
			if (finishCount == input.length) break; // 위의 작업이 끝났을 떄 모두 끝났으면 종료
			
			while (true) { // 다음 실행할 작업 탐색
				running = (running+1) % input.length;
				if (!isFinish[running]) break;
			}
			
			totalExe++;
		}
		
		if (finishCount == input.length) System.out.println(-1);
		else System.out.println(running+1);
	}

}

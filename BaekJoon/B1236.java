package backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1236 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		
		// 성 정보를 배열로 생성
		boolean[][] arr = new boolean[row][column];
		String[] temp = new String[column];
		for (int i=0; i<row; i++) {
			temp = br.readLine().split("");
			
			for (int j=0; j<column; j++) {
				if (temp[j].equals("X")) arr[i][j] = true;
			}
		}
		
		int notRowGuard = 0; // 가드가 없는 row의 수
		int notColumnGuard = 0; // 가드가 없는 column의 수
		boolean hasGuard;
		// Guard가 없는 Row 체크
		for (int i=0; i< row; i++) {
			hasGuard = false;
			for (int j=0; j<column; j++) {
				if (arr[i][j]) { // 가드가 해당 라인에 존재하면 해당 줄은 탐색 종료
					hasGuard = true;
					break;
				}
			}
			if (!hasGuard) notRowGuard++;
		}
		
		// Guard가 없는 Column 체크
		for (int i=0; i< column; i++) {
			hasGuard = false;
			for (int j=0; j<row; j++) {
				if (arr[j][i]) { // 가드가 해당 라인에 존재하면 해당 줄은 탐색 종료
					hasGuard = true;
					break;
				}
			}
			if (!hasGuard) notColumnGuard++;
		}
		
		// guard가 없는 line이 더 많은 값 출력
		System.out.println(notRowGuard>notColumnGuard ? notRowGuard:notColumnGuard);
	}

}

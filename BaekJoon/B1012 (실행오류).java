import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int numOfCabbage = Integer.parseInt(st.nextToken());
			
			boolean[][] farm = new boolean[height][width]; // 배추의 위치를 나타냄
			boolean[][] check = new boolean[height][width]; // 해당 구역을 확인했는지 체크
			for (int j=0; j< numOfCabbage; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				farm[y][x] = true;
			}
		
			bw.write(findResult(farm, check, width, height)+"\n");
		}
		bw.flush();
		bw.close();
		
	}
	// BFS사용
	static int findResult(boolean[][] farm, boolean[][] check, int width, int height) {
		int count = 0;
		// 객체로 배추정보를 queue로 받을 수 있겠지만 2개의 queue를 만들어 x,y좌표를 따로 받겠습니다.
		Queue<Integer> xQueue;
		Queue<Integer> yQueue;
		// Set은 check를 통해 확인할 수 있기에 필요없음
		
		
		for (int i=0; i<height; i++) {
			for (int j=0; j<width; j++) {
				if (check[i][j]) continue; //해당 구역을 체크했으면 pass
				if (!farm[i][j]) { // 해당 구역에 배추가 없으면 check를 true로 변경 후 pass
					check[i][j] = true;
					continue;
				}
				else { // 해당 구역을 체크하지 않았고 배추가 있는 경우 BFS를 통해 배추 탐색
					count++;
					xQueue = new LinkedList<>();
					yQueue = new LinkedList<>();
					xQueue.add(j);
					yQueue.add(i);
					 
					int x; 
					int y;
					  
					while(!xQueue.isEmpty() && !yQueue.isEmpty()) {
						x = xQueue.poll();
						y = yQueue.poll();
						if (farm[y][x] && !check[y][x]) {
							check[y][x] = true;
							
							if (checkXY(width, height, x-1, y)) {
								xQueue.add(x-1);
								yQueue.add(y);
							}
							if (checkXY(width, height, x+1, y)) {
								xQueue.add(x+1);
								yQueue.add(y);
							}
							if (checkXY(width, height, x, y+1)) {
								xQueue.add(x);
								yQueue.add(y+1);
							}
							
						}
					}
				}
			}
		}
	
		return count;
	}
	static boolean checkXY(int width, int height, int x, int y) {
		if (0 <= x && x < width && 0 <= y && y<height) return true;
		
		return false;
	}

}

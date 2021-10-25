package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B12100 {
	
	static int result;
	static int[][] matrix;
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		matrix = new int[N][N];
		
		for (int i=0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j< N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(result);
	}
	
	
	static void dfs(int moveCount) {
		if (moveCount == 5) {
			findMax();
		}
		else {
			int[][] temp = new int[N][N];
			for (int i=0; i<N; i++) {
				temp[i] = matrix[i].clone();
			}
			
			for (int i=0; i<4; i++) {
				move(i);
				dfs(moveCount + 1);
				for (int j=0; j<N; j++) {
					matrix[j] = temp[j].clone();
				}
				
			}
			
			
			// 상하좌우로 이동!
			
		}
	}
	
	private static void findMax() {
		// TODO Auto-generated method stub
		for (int i=0; i< N; i++) {
			for (int j=0; j< N; j++) {
				result = Math.max(result, matrix[i][j]);
			}
		}
	}
	// 상하좌우로 이동 후 점수합치기
	static void move(int idx) {
		 switch(idx) {
	        //위로 몰기
			case 0:
			    for(int i = 0; i < N; i++) {
			        int index = 0;
			        int block = 0;
			        for(int j = 0; j < N; j++) {
			            if(matrix[j][i] != 0) {
			                if(block == matrix[j][i]) {
			                    matrix[index - 1][i] = block * 2;
			                    block = 0;
			                    matrix[j][i] = 0;
			                }
			                else {
			                    block = matrix[j][i];
			                    matrix[j][i] = 0;
			                    matrix[index][i] = block;
			                    index++;
			                }
			            }
			        }
			    }
			    break;
			//왼쪽으로 몰기
			case 1:
			    for(int i = 0; i < N; i++) {
			        int index = N - 1;
			        int block = 0;
			        for(int j = N - 1; j >= 0; j--) {
			            if(matrix[j][i] != 0) {
			                if(block == matrix[j][i]) {
			                    matrix[index + 1][i] = block * 2;
			                    block = 0;
			                    matrix[j][i] = 0;
			                }
			                else {
			                    block = matrix[j][i];
			                    matrix[j][i] = 0;
			                    matrix[index][i] = block;
			                    index--;
			                }
			            }
			        }
			    }
			    break;
			//왼쪽으로 몰기
			case 2:
			    for(int i = 0; i < N; i++) {
			        int index = 0;
			        int block = 0;
			        for(int j = 0; j < N; j++) {
			            if(matrix[i][j] != 0) {
			                if(block == matrix[i][j]) {
			                    matrix[i][index - 1] = block * 2;
			                    block = 0;
			                    matrix[i][j] = 0;
			                }
			                else {
			                    block = matrix[i][j];
			                    matrix[i][j] = 0;
			                    matrix[i][index] = block;
			                    index++;
			                }
			            }
			        }
			    }
			    break;
			//오른쪽으로 몰기
		    case 3:
		        for(int i = 0; i < N; i++) {
		            int index = N - 1;
		            int block = 0;
		            for(int j = N - 1; j >= 0; j--) {
		                if(matrix[i][j] != 0) {
		                    if(block == matrix[i][j]) {
		                        matrix[i][index + 1] = block * 2;
		                        block = 0;
		                        matrix[i][j] = 0;
		                    }
		                    else {
		                        block = matrix[i][j];
		                        matrix[i][j] = 0;
		                        matrix[i][index] = block;
		                        index--;
		                    }
		                }
		            }
		        }
		        break;
	    }
	}

}

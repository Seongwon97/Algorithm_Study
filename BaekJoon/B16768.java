package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B16768 {

   static class Point{
      int x, y;
      public Point(int y, int x) {
         this.x = x;
         this.y = y;
      }
   }
   
   static Stack<Point> stack = new Stack<>();
   static int N,K,cnt;
   static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
   static int[][] matrix;
   static boolean[][] visited;
   
   public static void main(String[] args) throws IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      
      matrix = new int[N+1][11];
      for (int i=1; i<=N; i++) {
         char[] str = br.readLine().toCharArray();
         for(int j=1; j<=10; j++) {
            matrix[i][j] = str[j-1] - '0';
         }
      }
      while(true) {
         visited = new boolean[N+1][11];
         boolean flag = false;
         
         
         for (int i=N; i>0; i--) {
            for (int j=1; j<=10; j++) {
               if (visited[i][j] || matrix[i][j]==0) continue;
               stack.clear();
               cnt = 0;
               DFS(i, j, matrix[i][j]);
               
               if (cnt >= K) {
                  flag = true;
                  for (Point p:stack) matrix[p.y][p.x] = 0;
                  downward();
               }
            }
         } 
         if (!flag) break;
      }
      
      StringBuilder sb = new StringBuilder();
      for (int i=1; i<=N; i++) {
         for (int j=1; j<=10; j++)
            sb.append(matrix[i][j]);
         sb.append("\n");
      }
      System.out.println(sb.toString());
   }
   
   static void downward() {
      for (int i= N-1; i>0; i--) {
         for (int j=1; j<=10; j++) {
            if (matrix[i][j] == 0 || matrix[i+1][j] != 0) continue;
            
            int z = i+1;
            while(z <= N && matrix[z][j] == 0) {
               matrix[z][j] = matrix[z-1][j];
               matrix[z-1][j] = 0;
               z++;
            }
         }
      }
   }
	   
   static void DFS (int y, int x, int value) {
      cnt++;
      visited[y][x] = true;
      stack.push(new Point(y,x));
      
      for (int a=0; a<4; a++) {
         int ny = y+dy[a];
         int nx = x+dx[a];
         
         if (ny < 1 || nx < 1 || ny > N || nx > 10 || visited[ny][nx] || matrix[ny][nx]!=value) continue;
         
         DFS(ny, nx, value);
      }
    }

}
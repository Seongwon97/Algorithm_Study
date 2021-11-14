package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class B2644 {
 
    static int[][] map;
    static int n, p1, p2, par_ch;
    static int[] check;
 
    static void BFS(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int i = 1; i < map.length; i++) {
                if (map[x][i] == 1 && check[i] == 0) {
                    q.offer(i);
                    check[i] = check[x] + 1; // check에 저장.
                }
            }
        }
        System.out.println(check[p2] == 0 ? -1 : check[p2]);
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken()); // 비교대상 1
        p2 = Integer.parseInt(st.nextToken()); // 비교대상 2
        par_ch = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수
        map = new int[n + 1][n + 1]; // index 1 부터
 
        for (int i = 0; i < par_ch; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        check = new int[n + 1];
 
        BFS(p1);
 
    }
 
}

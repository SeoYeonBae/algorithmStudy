package d4;

import java.io.*;
import java.util.*;
 
public class Solution_8382_방향전환 {
 
    static int finalR, finalC, min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int startR = Integer.parseInt(st.nextToken()) + 100;
            int startC = Integer.parseInt(st.nextToken()) + 100;
            finalR = Integer.parseInt(st.nextToken()) + 100;
            finalC = Integer.parseInt(st.nextToken()) + 100;
             
            visited = new boolean[201][201][2];
            min = Integer.MAX_VALUE;
            bfs(startR, startC);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        br.close();
        bw.append(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.offer(new int[] {startR, startC, 0, 0});
        q.offer(new int[] {startR, startC, 0, 1});
        visited[startR][startC][0] = true;
        visited[startR][startC][1] = true;
         
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            int dir = cur[3]; // 0이면 상하 이동 1이면 좌우 이동
             
            if(cnt > min)
                continue;
             
            if(r == finalR && c == finalC) {
                min = cnt < min? cnt : min;
                return;
            }
             
            if(dir == 0) {  // 상하 이동
                for (int d = 0; d < 2; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                     
                    if(nr < 0 || nr > 200 || nc < 0 || nc > 200)
                        continue;
                     
                    if(visited[nr][nc][dir])
                        continue;
                     
                    visited[nr][nc][dir] = true;
                    q.offer(new int[] {nr, nc, cnt + 1, 1});
                }
            }else { // 좌우 이동
                for (int d = 2; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                     
                    if(nr < 0 || nr > 200 || nc < 0 || nc > 200)
                        continue;
                     
                    if(visited[nr][nc][dir])
                        continue;
                     
                    visited[nr][nc][dir] = true;
                    q.offer(new int[] {nr, nc, cnt + 1, 0});
                }
                 
            }
        }
         
    }
}
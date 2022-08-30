package test;

import java.io.*;
import java.util.*;

public class Solution_헌터 {

	static int res, N, M;
	static boolean[][] visited;
	static int[][] monster, customer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N + 1][N + 1];
			M = 0;
			
			monster = new int[5][2];
			customer = new int[5][2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num > 0) {
						monster[num][0] = i;
						monster[num][1] = j;
						M++;
					}
					else if(num < 0) {
						customer[num * -1][0] = i;
						customer[num * -1][1] = j;
					}
				}
			}
			res = Integer.MAX_VALUE;
			solve(1, 1, 0, 0);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static private void solve(int r, int c, int cnt, int dist) {
		if(cnt == 2*M) {
			res = Math.min(res, dist);
			return;
		}
		
		for (int i = 1; i <= M; i++) {
			int mr, mc, cr, cc;
			mr = monster[i][0];
			mc = monster[i][1];
			cr = customer[i][0];
			cc = customer[i][1];
			if(!visited[mr][mc]) {	// 몬스터 좌표에 방문 안 함
				visited[mr][mc] = true;
				solve(mr, mc, cnt + 1, dist + Math.abs(mr - r) + Math.abs(mc - c));
				visited[mr][mc] = false;
			}
			if(visited[mr][mc] && !visited[cr][cc]) {	// 몬스터 좌표에 방문하고 손님 집에 방문 안 함
				visited[cr][cc] = true;
				solve(cr, cc, cnt + 1, dist + Math.abs(cr - r) + Math.abs(cc - c));
				visited[cr][cc] = false;
			}
		}
	}
}

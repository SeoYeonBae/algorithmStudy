package d3;

import java.io.*;
import java.util.*;

public class Solution_2814_최장경로 {

	static int N, cnt, res;
	static int[][] adjMap;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(M == 0) {
				sb.append("#").append(tc).append(" ").append(1).append("\n");
				continue;
			}
			
			adjMap = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjMap[from][to] = 1;
				adjMap[to][from] = 1;
			}
			
			res = Integer.MIN_VALUE;
			visited = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				dfs(1, i);
				visited[i] = false;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int cnt, int start) {		
		visited[start] = true;
		
		for (int i = 1; i <= N; i++) {
			if(adjMap[start][i] == 1 && !visited[i]) {
				dfs(cnt + 1, i);
				visited[i] = false;
			}
		}
		
		res = Math.max(res, cnt);
	}
}

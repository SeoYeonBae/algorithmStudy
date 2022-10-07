package d4;

import java.io.*;
import java.util.*;

public class Solution_5643_키순서 {

	static int N, M;
	static int[][] adjMap;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			adjMap = new int[N + 1][N + 1];
			for (int i = 1; i < N + 1; i++) {
				Arrays.fill(adjMap[i], 0);
			}
			M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				adjMap[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int res = 0;
			for (int i = 1; i < N+1; i++) {
				visited = new boolean[N + 1];
				int tCnt = bfsTall(i);
				visited = new boolean[N + 1];
				int sCnt = bfsShort(i);
				if(tCnt + sCnt == N - 1)
					res++;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static int bfsShort(int v) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		int res = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1; i < N + 1; i++) {
				if(adjMap[i][cur] == 1) {
					if(visited[i])
						continue;
					res++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return res;
	}
	private static int bfsTall(int v) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(v);
		int res = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 1; i < N + 1; i++) {
				if(adjMap[cur][i] == 1) {
					if(visited[i])
						continue;
					res++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
		return res;
	}

	
}

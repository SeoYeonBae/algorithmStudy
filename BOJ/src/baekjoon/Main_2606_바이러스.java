package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {

	static int N, M, cnt;
	static int[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		cnt = -1;	// 자기 자신은 뺌
		visit = new boolean[N + 1];
		dfs(1);
		System.out.println(cnt);
	}
	
	private static void dfs(int v) {
		if(visit[v])
			return;
		
		cnt++;
		visit[v] = true;
		
		for (int i = 1; i <= N; i++) {
			if(map[v][i] == 1)
				dfs(i);
		}
	}
}

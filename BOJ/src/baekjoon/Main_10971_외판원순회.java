package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_외판원순회 {
	static int N, ans = Integer.MAX_VALUE;
	static int[][] adjMap;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		adjMap = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, i, 0, 0);
			visited[i] = false;
		}
		
		System.out.println(ans);

	}

	private static void dfs(int start, int cur, int cnt, int sum) {

		if(sum > ans) return;
		
		if (cnt == N - 1) {
			if (adjMap[cur][start] != 0)
				ans = Math.min(ans, sum + adjMap[cur][start]);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjMap[cur][i] != 0) {
				visited[i] = true;
				dfs(start, i, cnt + 1, sum + adjMap[cur][i]);
				visited[i] = false;
			}
		}
	}
	
}
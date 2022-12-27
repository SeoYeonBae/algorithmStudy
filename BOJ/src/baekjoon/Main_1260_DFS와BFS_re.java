package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1260_DFS와BFS_re {

	static int N, M, V;
	static int[][] adjMap;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		adjMap = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjMap[a][b] = 1;
			adjMap[b][a] = 1;
		}
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs();

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();

	}

	private static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		visited[V] = true;
		sb.append(V).append(" ");

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= N; i++) {
				if (adjMap[cur][i] == 0)
					continue;

				if (visited[i])
					continue;

				visited[i] = true;
				sb.append(i).append(" ");
				q.offer(i);
			}
		}
	}

	private static void dfs(int v) {
		if (visited[v])
			return;

		visited[v] = true;
		sb.append(v).append(" ");

		for (int j = 1; j <= N; j++) {
			if (adjMap[v][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}

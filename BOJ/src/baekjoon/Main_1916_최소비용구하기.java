package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기 {

	static int INF = 100001;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] adjMap = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(adjMap[i], INF);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjMap[a][b] = Math.min(adjMap[a][b], c);
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 출발지
		int finish = Integer.parseInt(st.nextToken()); // 도착지

		// 다익스트라 이용
		int[] dijk = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(visited, false);
		Arrays.fill(dijk, Integer.MAX_VALUE);
		dijk[start] = 0;	// 출발지에서 출발지는 0

		int min, minV;

		for (int i = 1; i <= N; i++) {
			min = Integer.MAX_VALUE;
			minV = -1;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > dijk[j]) {
					min = dijk[j];
					minV = j;
				}
			}
			
			visited[minV] = true;
			
			if(minV == finish)
				break;
			
			for (int j = 0; j <= N; j++) {
				// 아직 방문 안 했고, 갈 수 있는 버스가 있고, 경유해서 가는 게 더 빠르면 갱신
				if(!visited[j] && adjMap[minV][j] != INF && dijk[j] > dijk[minV] + adjMap[minV][j])
					dijk[j] = dijk[minV] + adjMap[minV][j];
			}
		}
		
		System.out.println(dijk[finish]);
	}

}

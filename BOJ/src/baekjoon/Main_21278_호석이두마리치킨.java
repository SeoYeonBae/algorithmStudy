package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_21278_호석이두마리치킨 {

	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(i == j)
					continue;
				map[i][j] = 987654321;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		// 플로이드 워셜로 각 정점들간의 최소 거리를 구함
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		int chicken1 = Integer.MAX_VALUE;
		int chicken2 = Integer.MAX_VALUE;
		int res = Integer.MAX_VALUE;
		
		// 치킨 집 2개 뽑아서 거리 확인
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				int dis = distance(i, j);
				if(res > dis) {
					chicken1 = i;
					chicken2 = j;
					res = dis;
				}
			}
		}
		
		sb.append(chicken1).append(" ").append(chicken2).append(" ").append(res * 2);
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}

	private static int distance(int r, int c) {
		int res = 0;
		for (int i = 1; i <= N; i++) {
			// 치킨집 2개에 대해 더 가까운 치킨집 거리 구해서 더해줌
			res += Math.min(map[r][i], map[c][i]);
		}
		return res;
	}
}

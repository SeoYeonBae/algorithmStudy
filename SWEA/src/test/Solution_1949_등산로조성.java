package test;

import java.io.*;
import java.util.*;

public class Solution_1949_등산로조성 {

	static int N, K, res;
	static int[][] originMap, copyMap;
	static boolean[][] visited;
	static List<int[]> maxList;
	static int[] dr = {0,0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			originMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					originMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			maxList = new ArrayList<int[]>();
			findMax();
			res = Integer.MIN_VALUE;
			visited = new boolean[N][N];
			copyMap = new int[N][N];
			for (int i = 0; i < maxList.size(); i++) {
				arrayInit();
				dfs(maxList.get(i), false, 1);
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void dfs(int[] point, boolean isK, int cnt) {
		res = Math.max(res, cnt);
		int r = point[0];
		int c = point[1];
		visited[r][c] = true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= N)
				continue;
			
			if(visited[nr][nc])
				continue;
			
			if(copyMap[nr][nc] < copyMap[r][c])
				dfs(new int[] {nr, nc}, isK, cnt + 1);
			else {
				if(isK)
					continue;
				int depth = copyMap[nr][nc] - copyMap[r][c] + 1;
				
				if(depth <= K) {
					copyMap[nr][nc] -= depth;
					dfs(new int[] {nr, nc}, true, cnt + 1);
					copyMap[nr][nc] += depth;
				}

			}
			visited[nr][nc] = false;
		}
	}
	
	private static void arrayInit() {
		for (int i = 0; i < N; i++) {
			System.arraycopy(originMap[i], 0, copyMap[i], 0, N);
			Arrays.fill(visited[i], false);
		}
		
	}
	private static void findMax() {
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(originMap[i][j] > max)
					max = originMap[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(originMap[i][j] == max)
					maxList.add(new int[] {i, j});
			}
		}
		
	}
}

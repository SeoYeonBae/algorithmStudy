package test;

import java.io.*;
import java.util.*;

public class Solution_2382_미생물격리 {

	static int N, M, K, res;
	static int[][] gunzip;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			gunzip = new int[K + 1][4];
			gunzip[0][2] = Integer.MAX_VALUE;
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				gunzip[i][0] = Integer.parseInt(st.nextToken());
				gunzip[i][1] = Integer.parseInt(st.nextToken());
				gunzip[i][2] = Integer.parseInt(st.nextToken());
				gunzip[i][3] = Integer.parseInt(st.nextToken());
			}
			
			res = 0;
			go();
			sb.append("#").append(tc).append(" ").append(res).append("\n");
			
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void go() {
		int[][] map = new int[N][N];
		
		for (int i = 0; i < M; i++) {

			for (int j = 0; j < N; j++)
				Arrays.fill(map[j], 0);
			
			Arrays.sort(gunzip, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o2[2] - o1[2];
				}
			});
			
			for (int j = 1; j <= K; j++) {
				if(gunzip[j][2] == 0)
					continue;
				
				int nr = gunzip[j][0] + dr[gunzip[j][3]];
				int nc = gunzip[j][1] + dc[gunzip[j][3]];
				
				if(map[nr][nc] != 0) {
					int idx = map[nr][nc];
					if(gunzip[j][2] > gunzip[idx][2]) {
						gunzip[j][2] += gunzip[idx][2];
						gunzip[idx][2] = 0;
						map[nr][nc] = j;
					}else {
						gunzip[idx][2] += gunzip[j][2];
						gunzip[j][2] = 0;
					}
				}else {
					map[nr][nc] = j;
				}
				
				if(nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
					gunzip[j][2] /= 2;
					if(gunzip[j][2] == 0) {
						map[nr][nc] = 0;
						continue;
					}
					if(gunzip[j][3] == 1 || gunzip[j][3] == 3)
						gunzip[j][3] += 1;
					else
						gunzip[j][3] -= 1; 
				}
				gunzip[j][0] = nr;
				gunzip[j][1] = nc;
			}
		}
		for (int i = 1; i <= K; i++) {
			res += gunzip[i][2];
		}
		return;
	}
}

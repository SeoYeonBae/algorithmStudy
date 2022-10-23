package d2;

import java.io.*;
import java.util.*;

public class Solution_1961_숫자배열회전 {

	static int N;
	static int[][] newMap1, newMap2, newMap3;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");

			N = Integer.parseInt(br.readLine());
			int[][] originMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					originMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] newMap1 = new int[N][N];
			rotate(newMap1, originMap);
			int[][] newMap2 = new int[N][N];
			rotate(newMap2, newMap1);
			int[][] newMap3 = new int[N][N];
			rotate(newMap3, newMap2);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(newMap1[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(newMap2[i][j]);
				}
				sb.append(" ");
				for (int j = 0; j < N; j++) {
					sb.append(newMap3[i][j]);
				}
				sb.append("\n");
			}
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void rotate(int[][] newMap, int[][] originMap) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				q.offer(originMap[i][j]);
			}
		}
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				newMap[j][i] = q.poll();
			}
		}
	}

}

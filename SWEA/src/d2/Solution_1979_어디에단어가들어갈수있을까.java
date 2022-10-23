package d2;

import java.io.*;
import java.util.*;

public class Solution_1979_어디에단어가들어갈수있을까 {

	static int N, K;
	static int[][] map;
	static List<Integer> list;

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
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			list = new ArrayList<Integer>();
			countBlock();

			int res = 0;
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) == K)
					res++;
			}
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void countBlock() {
		int cnt;
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					if (cnt != 0) {
						list.add(cnt);
					}
					cnt = 0;
				} else {
					cnt++;
				}
			}
			if (cnt != 0) {
				list.add(cnt);
			}
		}
		for (int i = 0; i < N; i++) {
			cnt = 0;
			for (int j = 0; j < N; j++) {
				if (map[j][i] == 0) {
					if (cnt != 0) {
						list.add(cnt);
					}
					cnt = 0;
				} else {
					cnt++;
				}
			}
			if (cnt != 0) {
				list.add(cnt);
			}
		}
	}
}

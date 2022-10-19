package test;

import java.io.*;
import java.util.*;

public class Solution_2112_보호필름_re {

	static int D, W, K, res;
	static int[][] origin;
	static int[][] copy;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			origin =  new int[D][W];
			copy =  new int[D][W];
			
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					origin[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			res = Integer.MAX_VALUE;
			
			if(check(origin) || K == 1) {
				res = 0;
			}else {
				for (int i = 1; i < D; i++) {
					mapCopy();
					comb(0, 0, i);
					if(res != Integer.MAX_VALUE) {
						break;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void comb(int start, int cnt, int R) {
		if(cnt == R) {
			if(check(copy))
				res = R;
			return;
		}
		for (int ab = 0; ab < 2; ab++) {
			for (int row = start; row < D; row++) {
				insert(ab, row);
				comb(row + 1, cnt + 1, R);
				delete(row);
			}
		}
	}
	private static void delete(int row) {
		for (int i = 0; i < W; i++) {
			copy[row][i] = origin[row][i];
		}
		
	}
	private static void insert(int ab, int row) {
		for (int i = 0; i < W; i++) {
			copy[row][i] = ab;
		}
	}
	private static void mapCopy() {
		for (int i = 0; i < D; i++) {
			System.arraycopy(origin[i], 0, copy[i], 0, W);
		}
		
	}
	private static boolean check(int[][] map) {
		for (int i = 0; i < W; i++) {
			int cnt = 1;
			for (int j = 0; j < D - 1; j++) {
				if(map[j][i] == map[j+1][i]) {
					cnt++;
					if(cnt == K)
						break;					
				}
				else
					cnt = 1;
			}
			if(cnt < K)
				return false;
		}
		return true;
	}
}

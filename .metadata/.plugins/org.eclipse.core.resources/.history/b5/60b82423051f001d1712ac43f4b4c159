package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] pSum = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j < N + 1; j++)
				pSum[i][j] = pSum[i][j - 1] + Integer.parseInt(st.nextToken());
		}
		
		int r1, c1, r2, c2;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			r1 = Integer.parseInt(st.nextToken());
			c1 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			sb.append(prefixSum(pSum, r1, c1, r2, c2)).append("\n");

		}
		System.out.println(sb);
	}

	private static int prefixSum(int[][] pSum, int r1, int c1, int r2, int c2) {
		int res = 0;	
		for(int i = r1; i <= r2; i++)
			res += (pSum[i][c2] - pSum[i][c1 - 1]);
		return res;
	}

}

package d2;

import java.io.*;
import java.util.*;

public class Solution_1959_두개의숫자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] A = new int[N];
			int[] B = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			int max = Integer.MIN_VALUE;
			if (N == M) {
				max = 0;
				for (int i = 0; i < N; i++) {
					max = max + (A[i] * B[i]);
				}
			} else {
				if (N < M) {
					for (int start = 0; start <= M - N; start++) {
						int sum = 0;
						for (int i = 0; i < N; i++) {
							int num = (B[start + i] * A[i]);
							sum += num;
						}
						max = Math.max(max, sum);
					}
				} else {
					for (int start = 0; start <= N - M; start++) {
						int sum = 0;
						for (int i = 0; i < M; i++) {
							int num = (A[start + i] * B[i]);
							sum += num;
						}
						max = Math.max(max, sum);
					}
				}

			}

			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

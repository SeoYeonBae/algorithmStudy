package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine(), " ");
		int[] pSum = new int[N + 1];
		for (int i = 1; i <= N; i++)
			pSum[i] = pSum[i - 1] + Integer.parseInt(st.nextToken());

		int start, end;
		for (int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			sb.append(prefixSum(pSum, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
		}
		System.out.println(sb);
	}

	private static int prefixSum(int[] pSum, int start, int end) {
		return pSum[end] - pSum[start - 1];
	}
}

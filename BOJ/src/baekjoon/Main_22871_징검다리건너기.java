package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_22871_징검다리건너기 {

	public static void main(String[] args) throws NumberFormatException, IOException {		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] A = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		int res = 0;
		long[] dp = new long[N];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;
		
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < j; i++) {
				dp[j] = Math.min(dp[j], Math.max((j - i) * (1 + Math.abs(A[i] - A[j])), dp[i]));
			}
		}
		System.out.println(dp[N - 1]);
	}
}

package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Main_10870_피보나치수5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		if(N >= 0) {
			dp[0] = 0;
		}
		if(N >= 1) {
			dp[1] = 1;
		}
		if(N >= 2) {
			for (int i = 2; i <= N; i++) {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		br.close();
	}
}

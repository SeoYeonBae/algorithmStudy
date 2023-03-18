package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_10422_괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		final int DIVIDE = 1000000007;
		
		int T = Integer.parseInt(br.readLine());
		int[] order = new int[T];
		for (int i = 0; i < T; i++) {
			order[i] = Integer.parseInt(br.readLine());
		}
		
		int N = 0;
		for (int i = 0; i < T; i++) {
			N = Math.max(N, order[i]);
		}
		
		long[] dp = new long[N + 1];
		
		dp[0] = 1;
		dp[1] = 0;
		dp[2] = 1;
		
		for (int i = 3; i <= N; i++) {
			if(i % 2 == 1)
				dp[i] = 0;
			
			else {
				for (int j = 2; j <= i; j += 2) {
					dp[i] = dp[i] + (dp[j - 2] * dp[i - j]); 
					dp[i] %= DIVIDE;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			sb.append(dp[order[i]]).append("\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}

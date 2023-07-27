package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1106_호텔 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int limit = C + 101;
		
		int[] dp = new int[limit];
		Arrays.fill(dp, 987654321);
		dp[0] = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int customer = Integer.parseInt(st.nextToken());
			for (int j = customer; j < limit; j++) {
				dp[j] = Math.min(dp[j], cost + dp[j - customer]);
			}
		}
		
		int res = Integer.MAX_VALUE;
		for (int i = C; i < limit; i++) {
			res = Math.min(res, dp[i]);
		}
		System.out.println(res);
	}
}

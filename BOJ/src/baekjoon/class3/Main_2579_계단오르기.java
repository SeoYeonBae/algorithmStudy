package baekjoon.class3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2579_계단오르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N =Integer.parseInt(br.readLine());
		int[] stair = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		if(N > 3) {
			dp[1] = stair[1];
			dp[2] = Math.max(stair[1] + stair[2], stair[2]);
			dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
			
			for(int i = 4; i <= N; i++) {
				dp[i] = Math.max(dp[i-2] + stair[i], dp[i-3] + stair[i-1] + stair[i]);
			}
		}else if(N == 3) {
			dp[1] = stair[1];
			dp[2] = Math.max(stair[1] + stair[2], stair[2]);
			dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
		}else if(N == 2) {
			dp[1] = stair[1];
			dp[2] = Math.max(stair[1] + stair[2], stair[2]);
		}else {
			dp[1] = stair[1];
		}
		br.close();
		System.out.println(dp[N]);
	}
}

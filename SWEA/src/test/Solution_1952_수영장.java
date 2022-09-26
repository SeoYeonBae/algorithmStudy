package test;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {

	static int[] cost, month, dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			cost = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			month = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[12];
			dp[0] = Math.min(month[0] * cost[0], cost[1]);
			for (int i = 1; i < 12; i++) {
				dp[i] = Math.min(dp[i - 1] + month[i] * cost[0], dp[i - 1] + cost[1]);
				
				if(i >= 2) {
					if(i == 2)
						dp[i] = Math.min(dp[i], cost[2]);
					else
						dp[i] = Math.min(dp[i], dp[i - 3] + cost[2]);
				}
			}
			
			sb.append("#").append(tc).append(" ").append(Math.min(dp[11], cost[3])).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

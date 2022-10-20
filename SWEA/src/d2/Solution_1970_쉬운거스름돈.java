package d2;

import java.io.*;

public class Solution_1970_쉬운거스름돈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			
			int N = Integer.parseInt(br.readLine());
			int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] dp = new int[8];
			
			for (int i = 0; i < 8; i++) {
				int coin = coins[i];
				if(N >= coin) {
					dp[i] = N / coin;
					N = N % coin;
				}
			}
			
			for (int i = 0; i < 8; i++) {
				sb.append(dp[i]).append(" ");
			}
			sb.append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

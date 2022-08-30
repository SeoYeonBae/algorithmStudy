package baekjoon.class3;

import java.io.*;

public class Main_11726_2xn타일링 {

	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			if(i < 3) dp[i] = i;
			else dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}
	

}

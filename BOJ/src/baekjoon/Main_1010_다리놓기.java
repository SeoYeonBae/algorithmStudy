package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {

	static int[][] dp = new int[30][30];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(comb(M, N)).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	// 조합 구하기
	private static int comb(int n, int r) {
		if(dp[n][r] != 0)
			return dp[n][r];

		if(n == r) {
			dp[n][r] = 1;
			return 1;
		}
		
		if(r == 1) {
			dp[n][r] = n;
			return n;
		}
		
		dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
		return dp[n][r];
	}

}

package baekjoon;

import java.io.*;

public class Main_11058_크리보드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N < 7) // 복사해서 붙여넣기로 이득을 보려면 최소 7은 돼야 함
			System.out.println(N);
		else {
			long[] dp = new long[N + 1];

			for (int i = 1; i < 7; i++) {
				dp[i] = i;
			}

			for (int i = 7; i < N + 1; i++) {
				long num = Math.max(dp[i - 3] * 2, dp[i - 4] * 3);
				dp[i] = Math.max(num, dp[i - 5] * 4);
			}
			
			System.out.println(dp[N]);
		}
	}
}

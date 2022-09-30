package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1463_1로만들기 {

	static int[] dp;
	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if (N == 1)
			System.out.println(0);
		else if (N == 2 || N == 3)
			System.out.println(1);
		else {
			dp = new int[N + 1];
			Arrays.fill(dp, 1000001);
			dp[1] = 0;
			dp[2] = dp[3] = 1;
			makeOne();
			System.out.println(dp[N]);
		}
		br.close();

	}

	private static void makeOne() {
		for (int i = 4; i <= N; i++) {
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			dp[i] = Math.min(dp[i], dp[i - 1] + 1);
		}
	}
}

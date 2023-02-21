package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15486_퇴사2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] day = new int[N + 1];
		int[] money = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i] = Integer.parseInt(st.nextToken());	// 상담에 필요한 기간
			money[i] = Integer.parseInt(st.nextToken());	// 상담했을 때 받을 수 있는 금액
		}
		int[] dp = new int[N + 2];
		for (int i = N; i >= 1; i--) {
			int nextDay = i + day[i];
			if (nextDay > N + 1) {	// 퇴사일을 넘긴 경우에는 이번 상담을 수행하지 않음
				dp[i] = dp[i + 1];	
			} else {	// 이번 상담을 수행하지 않는 경우와 상담을 수행하는 경우 중 최대를 구함
				dp[i] = Math.max(dp[i + 1], money[i] + dp[nextDay]);
			}
		}

		System.out.println(dp[1]);

	}
}

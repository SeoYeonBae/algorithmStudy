package test;

import java.io.*;
import java.util.*;

public class Solution_1952_수영장_re {

	static int[] money, plan, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			money = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}

			plan = new int[12];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[12];
			
			dp[0] = Math.min(plan[0] * money[0], money[1]); // Math.min(첫 달 사용 일수 * 1일 이용권, 1달 이용권)
			
			for (int i = 1; i < 12; i++) {
				// Math.min(전 달 요금 + 이번 달 사용 일수 * 1일 이용권, 전 달 요금 + 1달 이용권)
				dp[i] = Math.min(dp[i - 1] + (plan[i] * money[0]), dp[i - 1] + money[1]);
				
				if(i >= 2) {	// 3달 이용권을 사용 가능할 때
					if(i == 2) // 딱 3월이라면
						dp[i] = Math.min(dp[i], money[2]); // 지금까지 계산한 요금, 3개월 요금
					else // 4월부터는
						dp[i] = Math.min(dp[i], dp[i - 3] + money[2]);	
					// 지금까지 계산한 요금, 지금으로부터 3달 전까지의 요금 + 3개월 이용권
					// ex) Math.min(4월까지 계산한 요금, 1월 + 234월은 3개월 이용권)
				}
			}
			
			int res = Math.min(dp[11], money[3]);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void go() {

	}

}

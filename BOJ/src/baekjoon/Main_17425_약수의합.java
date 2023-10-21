package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_17425_약수의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = 1000001;
		long[] dp = new long[N];
		Arrays.fill(dp, 1);
		
		// 약수의 합 저장
		for (int i = 2; i < N; i++) {
			for (int j = 1; i * j < N; j++) {
				dp[i * j] += i;
			}
		}
		
		long[] sum = new long[N];
		// N 이하 수들의 약수의 합 저장
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + dp[i];
		}
		
		// 출력
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			sb.append(sum[Integer.parseInt(br.readLine())]).append("\n");
		}
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}

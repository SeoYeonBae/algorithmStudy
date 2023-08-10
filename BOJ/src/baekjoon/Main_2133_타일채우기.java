package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_2133_타일채우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		if(N % 2 == 1) {
			sb.append(0);
		}else {
			int[] dp = new int[N + 1];
			
			dp[0] = 1;
			dp[1] = 0;
			dp[2] = 3;
			
			for (int i = 4; i <= N; i += 2) {
				dp[i] = dp[i - 2] * dp[2];
				for (int j = i- 4; j > 0; j -= 2) {
					dp[i] = dp[i] + (dp[j] * 2); 
				}
				dp[i] += 2;	// 예외 케이스가 항상 2개씩 더 생김
			}
			
			sb.append(dp[N]);
		}
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
		
	}
}

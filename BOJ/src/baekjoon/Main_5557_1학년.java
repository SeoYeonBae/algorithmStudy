package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5557_1학년 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()) - 1;	// 마지막 숫자는 만들어야 하는 숫자니까 연산에 사용되는 숫자의 수는 입력값 -1
		
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N][21];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], 0);
		}
		
		dp[0][numbers[0]] = 1;	// 첫번째 수는 만들 수 있음
		
		for (int i = 1; i < N; i++) {		// 첫번째 수부터 검사
			for (int j = 0; j < 21; j++) {	// 최대 20까지 만들 수 있음 
				if(dp[i - 1][j] != 0) {		// 이전에 숫자를 만들 수 있었는지 없었는지 검사
					if(j + numbers[i] <= 20)
						dp[i][j + numbers[i]] = dp[i - 1][j] + dp[i][j + numbers[i]];
					if(j - numbers[i] >= 0)
						dp[i][j - numbers[i]] = dp[i - 1][j] + dp[i][j - numbers[i]];
				}
			}
		}
		
		System.out.println(dp[N - 1][answer]);
	}
}

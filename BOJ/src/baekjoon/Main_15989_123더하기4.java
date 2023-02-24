package baekjoon;

import java.io.*;

public class Main_15989_123더하기4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[10001][2];

		// 우선 1로만 만드는 방법은 어떤 수든 모두 한가지!
		
		// 2와 1만을 이용해 만드는 방법은 두가지로 나뉨
		// 짝수일 때는 이전 방법의 수에  +1이고  홀수 일 때는 이전 방법의 수와 동일함
		
		// 3까지 다 써서 만드는 방법은 i-3번째 수를 만드는 방법의 수와 같다
		
		// 1로만 만드는 방법은 어차피 1이기 때문에 배열에 저장하지 않음
		// dp[i][0] = 1과 2를 사용해 i번째  수를 만드는 방법의 수
		// dp[i][1] = 1, 2, 3을 사용해 i번째  수를 만드는 방법의 수		
		
		dp[1][0] = 0;	
		dp[1][1] = 0;

		dp[2][0] = 1;
		dp[2][1] = 0;

		dp[3][0] = 1;
		dp[3][1] = 1;

		for (int i = 4; i < 10001; i++) {
			if(i % 2 == 0)
				dp[i][0] = dp[i - 1][0] + 1;
			else
				dp[i][0] = dp[i - 1][0];
			
			dp[i][1] = 1 + dp[i -3][0] + dp[i -3][1];
		}
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			sb.append(1 + dp[input][0] + dp[input][1]).append("\n");
		}
		
		bw.append(sb.toString());
		bw.flush();
	}
}

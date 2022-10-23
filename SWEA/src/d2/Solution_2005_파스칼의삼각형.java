package d2;

import java.io.*;

public class Solution_2005_파스칼의삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
			int[][] dp = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					if(j == 0 || j == i) {
						dp[i][j] = 1;
						sb.append(dp[i][j]).append(" ");
					}else {
						dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
						sb.append(dp[i][j]).append(" ");
					}
				}
				sb.append("\n");
			}
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

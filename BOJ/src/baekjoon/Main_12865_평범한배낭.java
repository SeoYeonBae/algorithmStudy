package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()) + 1;
		int K = Integer.parseInt(st.nextToken()) + 1;
		
		int[][] item = new int[N][2];
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());	// 물건의 무게
			item[i][1] = Integer.parseInt(st.nextToken());	// 물건의 가치
		}
		
		int[][] dp = new int[N][K];
		for (int i = 1; i < N; i++) {		// 물건의 번호 
			for (int j = 1; j < K; j++) {	// 가방 무게
				dp[i][j] = dp[i - 1][j];	// 가방에 j무게까지 담을 수 있을 때 이전 물건까지 고려한 가치로 초기화 
				if(j >= item[i][0]) {	// 배낭의 무게가 물건의 무게보다 더 같거나 크다면 물건 담아봄
					// 기존 값, (현재 무게 j - i 물건의 무게)일 때의 가치 + i 물건의 가치 두 가지 중 큰 값
					// 현재 무게 j - i 물건의 무게를 해줌으로 i 물건을 담을 수 있게 함
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - item[i][0]] + item[i][1]);	 
				}
			}
		}
		
		System.out.println(dp[N - 1][K - 1]);
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2616_소형기관차 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// train[i] = i번째 train까지의 승객합
		// 매번 for문 돌려서 합을 구하는 것보다 빠를 것 같아 미리 저장함
		int train[] = new int[N + 1];
		train[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			train[i] = train[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		// 최대로 끌 수 있는 객차의 수
		int M = Integer.parseInt(br.readLine());
		
		// dp[i][j] = i번째 열차가 j번째 객차까지 고려했을 때의 최대 손님 수
		int[][] dp = new int[4][N + 1];
		
		for (int i = 1; i < 4; i++) {
			for(int j = i * M; j < N + 1; j++) {
				// dp[i][j - 1] = i번째 열차가 j번째 객차를 고려하지 않음
				// dp[i - 1][j - M] + train[j] - train[j - M]
				// = 이전 열차의 [j - M]번 객차까지의 최대 + i열차가 [j - M] ~ [j]까지 M개의 객차를 태운 승객 수
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - M] + train[j] - train[j - M]);
			}
		}
		
		System.out.println(dp[3][N]);
	}
}

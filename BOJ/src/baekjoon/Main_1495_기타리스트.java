package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1495_기타리스트 {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 곡의 개수
		int S = Integer.parseInt(st.nextToken());	// 시작 볼륨
		int M = Integer.parseInt(st.nextToken());	// 최대 볼륨
		
		int[] V = new int[N +  1];	// 조절할 수 있는 볼륨 차이
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			V[i]  = Integer.parseInt(st.nextToken());
		}
		
		// 최대 M까지 볼륨을 올릴 수 있는 상황에서 N개의 곡을 연주해볼게요
		boolean[][] dp = new boolean[N + 1][M + 1];
		
		dp[0][S] = true;	// 처음 스타트 볼륨은 S!
		
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < M + 1; j++) {
				if(dp[i - 1][j]) {	// 이전 볼륨이 연주 가능한 볼륨이었을 때
					if(j + V[i] <= M) {	// 다음 볼륨이 연주가능한  볼륨인지 판단
						dp[i][j + V[i]] = true;
					}
					if(j - V[i] >= 0) {
						dp[i][j - V[i]] = true;
					}
				}
			}
		}
		
		int res  =  -1;
		for (int i = M; i >= 0; i--) {
			if(dp[N][i]) {
				res  =  i;
				break;
			}
		}
		
		System.out.println(res);
	}
}

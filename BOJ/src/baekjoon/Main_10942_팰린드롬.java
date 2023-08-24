package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[N + 1][N + 1];
		// 길이가 1인 팰린드롬수 = S와 E가 같음
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		
		// 길이가 2인 팰린드롬수 = 2개의 수가 같음
		for (int i = 1; i < N; i++) {
			if(numbers[i] == numbers[i + 1])
				dp[i][i + 1] = true;
		}
		
		// 길이가 3 이상인 팰린드롬수
		// 조건 1. 시작하는 수와 마지막 숫자가 같아야 함
		// 조건 2. 조건 1의 두 수를 제외한 나머지 사이의 수들이 팰린드롬수이어야 함
		for (int i = 2; i < N; i++) {	// 팰린드롬수의 길이를 정할 변수
			for (int j = 1; j <= N - i; j++) {	// 팰린드롬 시작 인덱스
				if(numbers[j] == numbers[j + i] && dp[j + 1][j + i - 1])
					dp[j][j + i] = true;
			}
		}
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(dp[S][E])
				sb.append("1").append("\n");
			else
				sb.append("0").append("\n");
		}
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}

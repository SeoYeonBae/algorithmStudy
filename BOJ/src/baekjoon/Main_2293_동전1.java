package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[K + 1];
		dp[0] = 1; // 0원을 만드는 건 아무것도 뽑지 않는 한 가지
		for (int i = 0; i < N; i++) { // 동전의 수만큼 반복
			// j원보다 coin이 더 크면 어차피 0이라 현재 coin 금액부터 만듦
			for (int j = coin[i]; j <= K; j++) {
				// j원을 만들 수 있는 방법의 수 = 기존 j원을 만드는 방법의 수 + (j - 현재 coin의 금액)원을 만들었던 방법의 수
				// ex) 현재 coin = 5라면, dp[7] = dp[7] + dp[7-5]
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}
		
		System.out.println(dp[K]);
	}
}

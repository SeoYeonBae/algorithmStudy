package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		// dp 배열 초기화
		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;	// 0원을 만드는 동전의 수는 0개

		// 뒤에 나오는 반복문 로직이 동전 하나를 가지고 모든 금액을 만든 뒤에 다른 동전을 씀
		// ex) 1원으로 1-15원 만들고 5원으로 1-15원 만들어 나가는 식
		// 따라서 작은 동전을 먼저 이용해 최대한 많은 값을 만들어야 dp 갱신할 때 사용 가능
		// 아래 로직과 반대로 금액 하나에 동전을 사용해서 만들어간다면 정렬 안 해도 될 것 같음
		// ex) 1원을 1, 5, 12원으로 만들어 봄 -> 2원을 1, 5, 12원으로 만들어 봄
		Arrays.sort(coin);

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				// (만들어야 하는 값 - 현재 coin 값) = 현재 코인 값을 제외한 값
				// 이 값이 앞에서 만들 수 있는 금액이었을 때만 dp를 갱신
				if (dp[j - coin[i]] != Integer.MAX_VALUE)
					dp[j] = Math.min(1 + dp[j - coin[i]], dp[j]);
					// Math.min(현재 코인의 수 (1) + 현재 코인 값을 제외한 값을 만드는 최소 동전 수, 기존 최솟값)
			}
		}

		if (dp[k] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}

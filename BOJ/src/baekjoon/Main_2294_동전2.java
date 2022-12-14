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

		// 앞에서 작은 동전부터 만들어야 뒤에서 dp값을 사용할 수 있음 -> 정렬 필요
		Arrays.sort(coin);

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				// 앞에서 작은 단위의 동전으로 만들 수 있었다면
				// or 현재 동전의 값과 만들어야하는 값이 딱 떨어지는 수일 때만 갱신
				if (dp[j % coin[i]] != Integer.MAX_VALUE)
					dp[j] = Math.min((j / coin[i]) + dp[j % coin[i]], dp[j]);
			}
		}

		if (dp[k] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}

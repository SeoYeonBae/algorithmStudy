package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_12026_거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();

		int[] dp = new int[N];
		// Integer.MaxValue로 초기화하면 dp[i] + ((j - i) * (j - i)) 계산에서 터짐
		// 방문했던 곳에서 가는 게 아니라 0~N까지 차례대로 가기 때문에 방문 안 한 곳도 갈 수 있음 dp[i]
		// 그곳에서 연산하면 dp[i]가 Integer.Max_Value라 터짐
		Arrays.fill(dp, 999999999);
		dp[0] = 0; // 현재 소모한 에너지는 0

		for (int i = 0; i < N; i++) {
			char curChar = input.charAt(i); // 출발지

			switch (curChar) { // 현재 문자에 따른 다음 문자 검사
			case 'B':
				for (int j = i + 1; j < N; j++) { // 다음에 올 문자 중에 어떤 곳으로 가야 최적의 해일지 검사
					if (input.charAt(j) != 'O') // B일 때는 O가 아니라면 무시
						continue;
					// 기존 dp 값, 현재 소모한 에너지양 + 소모하게 될 에너지 양 중 최소
					dp[j] = Math.min(dp[j], dp[i] + ((j - i) * (j - i)));
				}
				break;
			case 'O':
				for (int j = i + 1; j < N; j++) {
					if (input.charAt(j) != 'J')
						continue;
					dp[j] = Math.min(dp[j], dp[i] + ((j - i) * (j - i)));
				}
				break;
			case 'J':
				for (int j = i + 1; j < N; j++) {
					if (input.charAt(j) != 'B')
						continue;
					dp[j] = Math.min(dp[j], dp[i] + ((j - i) * (j - i)));
				}
				break;
			}
		}

		if (dp[N - 1] == 999999999)
			System.out.println(-1);
		else
			System.out.println(dp[N - 1]);
	}
}

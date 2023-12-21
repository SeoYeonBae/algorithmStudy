package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2624_동전바꿔주기 {

	static class Coin implements Comparable<Coin>{
		int p, n;
		
		public Coin(int p, int n) {
			this.p = p;
			this.n = n;
		}

		@Override
		public int compareTo(Coin c) {
			return this.p - c.p;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		List<Coin> coinList = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			coinList.add(new Coin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(coinList);
		
		int[] dp = new int[T + 1];
		// 0원을 만드는 방법
		dp[0] = 1;
		for (int i = 0; i < K; i++) {
			int p = coinList.get(i).p;
			int n = coinList.get(i).n;
			
			// 내림차순으로 계산해야 금액에 대한 중복 계산이 생기지 않음
			// j : 만들려는 금액
			for (int j = T; j >= p; j--) {
				// k : 동전의 개수
				for (int k = 1; k <= n; k++) {
					// 만들려는 금액 - (현재 동전 금액 * 현재 동전의 수)
					// 만들려는 금액 >= 현재 내가 가진 금액이어야 함
					if(j - (p * k) < 0)
						break;
					// dp[만들려는 금액] += dp[만들려는 금액 - 현재 내가 가진 금액]
					dp[j] += dp[j - (p * k)];
				}
			}
		}
		
		sb.append(dp[T]);
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}

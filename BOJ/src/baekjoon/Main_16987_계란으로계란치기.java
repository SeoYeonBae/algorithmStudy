package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16987_계란으로계란치기 {

	static int N, res;
	static int[][] egg;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		egg = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}

		res = 0;
		go(0, 0);
		System.out.println(res);
	}

	private static void go(int cur, int cnt) {
		if (cur == N) {
			res = Math.max(res, cnt);
			return;
		}
		// 현재 든 계란이 깨짐 or 이미 다 깸
		if (egg[cur][0] <= 0 || cnt == N)
			go(cur + 1, cnt);
		else {
			boolean isHit = false;

			for (int i = 0; i < N; i++) {
				// 현재 든 계란과 치려는 계란이 같음 or 치려는 계란이 이미 깨짐
				if (i == cur || egg[i][0] <= 0)
					continue;
				
				isHit = true;
				egg[i][0] -= egg[cur][1];
				egg[cur][0] -= egg[i][1];

				if (egg[i][0] <= 0 && egg[cur][0] <= 0) {
					go(cur + 1, cnt + 2);
				} else if (egg[i][0] <= 0 || egg[cur][0] <= 0) {
					go(cur + 1, cnt + 1);
				} else
					go(cur + 1, cnt);
				
				egg[i][0] += egg[cur][1];
				egg[cur][0] += egg[i][1];
			}
			// 깰 계란이 남아있지 않음
			if (!isHit)
				go(cur + 1, cnt);
		}
	}
}

package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {

	static int[] sour, bitter, numbers;
	static int R, N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		sour = new int[N];		// 신만
		bitter = new int[N];	// 쓴맛
		numbers = new int[N];	// 신맛과 쓴맛의 인덱스를 조합으로 만들기 위한 배열

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) { 	// 재료를 하나만 쓸 때부터 다 쓸 때까지의 모든 조합 만들기
			R = i;						// 재료 중에 몇 개 쓸 건지 정하기
			comb(0, 0);
		}

		System.out.println(min);

	}

	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int s = 1, b = 0;
			for (int i = 0; i < R; i++) {	// 조합 만들면 최솟값 구해서 조건에 따라 갱신
				s *= sour[numbers[i]];
				b += bitter[numbers[i]];
			}

			if (Math.abs(s - b) < min) {
				min = Math.abs(s - b);
			}

			return;
		}

		for (int i = start; i < N; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

}

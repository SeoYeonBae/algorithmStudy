package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1239_차트 {

	static int N, max, res;
	static int[] chart, nums;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		chart = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chart[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, chart[i]);
		}
		// 가장 큰 값이 50을 넘어가면 절대 반으로 나눌 수 없음
		if (max > 50)
			res = 0;
		// 가장 큰 값이 50이라면 1개가 맥스
		else if (max == 50)
			res = 1;
		else {
			nums = new int[N];
			visit = new boolean[N];
			perm(0);
		}

		System.out.println(res);
	}

	private static void perm(int cnt) {
		if (cnt == N) {
			res = Math.max(res, calc());
		}

		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				nums[cnt] = chart[i];
				perm(cnt + 1);
				visit[i] = false;
			}
		}

	}

	private static int calc() {
		int cnt = 0;
		int[] sum = new int[N];
		sum[0] = nums[0];
		for (int i = 1; i < N; i++) {
			sum[i] = sum[i - 1] + nums[i];
		}
		// 현재 누적값에 50을 더한 값이 차트에 존재하면 반으로 나눠졌다는 뜻!
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (sum[i] + 50 == sum[j]) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}
}

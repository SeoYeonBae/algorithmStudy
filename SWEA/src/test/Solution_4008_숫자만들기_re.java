package test;

import java.io.*;
import java.util.*;

public class Solution_4008_숫자만들기_re {

	static int N, max, min;
	static int[] signs, nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			int idx = 0;
			signs = new int[N - 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				int cnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < cnt; j++) {
					signs[idx++] = i;
				}
			}

			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			do {
				makeNum();
			} while (np());
			
			sb.append("#").append(tc).append(" ").append(max - min).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean np() {
		int M = N - 1;
		
		int i = M - 1;
		while(i > 0 && signs[i - 1] >= signs[i]) --i;
		
		if(i == 0) return false;
		
		int j = M - 1;
		while(signs[i - 1] >= signs[j]) --j;
		
		swap(i - 1, j);
		
		int k = M - 1;
		while(i < k) swap(i++, k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = signs[i];
		signs[i] = signs[j];
		signs[j] = tmp;
	}

	private static void makeNum() {
		int idx = 1;
		int sum = nums[0];
		for (int i = 0; i < N - 1; i++) {
			switch (signs[i]) {
			case 0:
				sum += nums[idx++];
				break;
			case 1:
				sum -= nums[idx++];
				break;
			case 2:
				sum *= nums[idx++];
				break;
			case 3:
				sum /= nums[idx++];
				break;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
	}
}

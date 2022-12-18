package baekjoon.samgsung;

import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {

	static int N, max, min;
	static int[] nums, orders;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());	// 입력 받은 수의 배열
		}
		
		orders = new int[N - 1];	// 연산자 저장할 배열 : 연산자는 늘 수의 -1개
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int limit = Integer.parseInt(st.nextToken());
			for (int j = 0; j < limit; j++) { // 연산자의 개수만큼 orders에 i를 넣어줌
				orders[idx++] = i;	// i의 의미: 0 = +, 1 = -, 2 = *, 3 = /  
			}
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		do {
			makeNum();
		} while (np());
		
		sb.append(max).append("\n").append(min);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean np() {
		int i = N - 2;
		while(i > 0  && orders[i - 1] >= orders[i]) --i;
		
		if(i == 0)
			return false;
		
		int j = N - 2;
		while(orders[i - 1] >= orders[j]) --j;
		
		swap(i - 1, j);
		
		int k = N - 2;
		while(i < k) swap(i++, k--);
		
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = orders[i];
		orders[i] = orders[j];
		orders[j] = tmp;
	}

	private static void makeNum() {
		int num = nums[0];
		for (int i = 0; i < N - 1; i++) {
			switch (orders[i]) {
			case 0:
				num += nums[i + 1];
				break;
			case 1:
				num -= nums[i + 1];
				break;
			case 2:
				num *= nums[i + 1];
				break;
			case 3:
				if(nums[i + 1] == 0)
					return;
				else
					num /= nums[i + 1];
				break;

			default:
				break;
			}
		}
		max = Math.max(max, num);
		min = Math.min(min, num);
		return;
	}
}

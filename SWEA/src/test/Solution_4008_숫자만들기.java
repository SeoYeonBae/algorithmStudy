package test;

import java.io.*;
import java.util.*;

public class Solution_4008_숫자만들기 {

	static int N, max, min;
	static int[] nums;
	final static int A = 100000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[] opers = new int[N-1];
			st = new StringTokenizer(br.readLine());
			int startIdx = 0;
			for (int i = 0; i < 4; i++) {
				int operCnt = Integer.parseInt(st.nextToken());
				for (int j = 0; j < operCnt; j++) {
					opers[startIdx + j] = i;
				}
				startIdx += operCnt;
			}
			
			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			do {
				long res = makeNum(opers);
				if(res != A) {
					max = (int) Math.max(max, res);
					min = (int) Math.min(min, res);
				}
			}while(np(opers));
			
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static long makeNum(int[] opers) {
		long sum = nums[0];
		for (int i = 0; i < opers.length; i++) {
			int  oper = opers[i];
			switch (oper) {
			case 0:
				sum = sum + nums[i + 1];
				break;
			case 1:
				sum = sum - nums[i + 1];
				break;
			case 2:
				sum = sum * nums[i + 1];
				break;
			case 3:
				if(nums[i + 1] != 0) {
					sum = sum / nums[i + 1];
				}else
					sum = A;
				break;
			}
			if(sum == A)
				return sum;
		}
		return sum;
	}

	private static boolean np(int[] opers) {
		int l = opers.length;
		
		int i = l - 1;
		while(i > 0 && opers[i - 1] >= opers[i]) --i;
		
		if(i == 0) return false;
		
		int j = l - 1;
		while(opers[i - 1] >= opers[j]) --j;
		
		swap(opers, i - 1, j);
		
		int k = l - 1;
		while(i < k) swap(opers, i++, k--);
		
		return true;
	}

	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}

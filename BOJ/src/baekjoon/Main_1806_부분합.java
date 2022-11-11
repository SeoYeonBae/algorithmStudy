package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1806_부분합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N] = 0;
		int start = 0;
		int end = 0;
		int sum = 0;
		int res = Integer.MAX_VALUE;
		
		while(start <= N && end <= N) {
			if(sum < S) {
				sum += arr[end];
				end++;
			}else {
				sum -= arr[start];
				res = Math.min(res, (end - start));
				start++;
			}
		}
		if(res == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(res);

		br.close();
	}
}
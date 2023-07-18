package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_20922_겹치는건싫어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] cnt = new int[100001];
		int start = 0;
		int end = 0;
		int res = 0;
		while(end < N) {
			if(cnt[array[end]] < K) {
				cnt[array[end]]++;
				end++;
			}else {
				cnt[array[start]]--;
				start++;
			}
			res = Math.max(res, end - start);
		}
		System.out.println(res);
	}
}

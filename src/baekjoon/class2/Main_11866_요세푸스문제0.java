package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> map = new ArrayList<>();
		for(int i = 0; i < N; i++)
			map.add(i);
		int idx = 0;
		for(int i = 0; i < K; i++) {
		
			map.remove(idx + K - 1);
			idx = idx + K - 1;
		}
		
	}
	
}

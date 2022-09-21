package baekjoon.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15654_N과M5 {

	static int N, M;
	static int[] input, numbers;
	static StringBuilder sb;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		numbers = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		comb(0, 0);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void comb(int count, int start) {
		if(count == M) {
			for (int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			if(visited[i] == true) continue;
			visited[i] = true;
			numbers[count] = input[i];
			comb(count + 1, start);
			visited[i] = false;
		}
		
	}
}

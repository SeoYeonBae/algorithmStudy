package baekjoon.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.*;

public class Main_15654_N과M9 {

	static int N, M;
	static int[] input, numbers;
	static StringBuilder sb;
	static boolean[] visited;
	static HashSet<String> tmp;

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
		tmp = new HashSet<>();

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
		if (count == M) {
			StringBuilder sb2 = new StringBuilder();
			for (int i = 0; i < M; i++) {
				sb2.append(numbers[i]).append(" ");
			}
			if(!tmp.contains(sb2.toString()))
				sb.append(sb2.toString()).append("\n");
			tmp.add(sb2.toString());
			return;
		}

		for (int i = start; i < N; i++) {
			if (visited[i] == true)
				continue;
			visited[i] = true;
			numbers[count] = input[i];
			comb(count + 1, start);
			visited[i] = false;
		}

	}
}

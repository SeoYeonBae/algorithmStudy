package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2668_숫자고르기 {

	static int N;
	static int[] numbers;
	static boolean[] visit;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		visit = new boolean[N + 1];
		list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			visit[i] = true;
			dfs(i, i);
			visit[i] = false;
		}
		
		sb.append(list.size()).append("\n");
		Collections.sort(list);
		for(Integer i : list)
			sb.append(i).append("\n");
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	private static void dfs(int start, int target) {
		if(!visit[numbers[start]]) {
			visit[numbers[start]] = true;
			dfs(numbers[start], target);
			visit[numbers[start]] = false;
		}
		
		if(numbers[start] == target) {
			list.add(target);
		}
	}

}

package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14567_선수과목 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] inDegree = new int[N + 1];
		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}
		
		int[] res = new int[N + 1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if(inDegree[i] == 0) {
				q.add(i);
				res[i] = 1;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			int size = list[cur].size();
			for (int i = 0; i < size; i++) {
				int next = list[cur].get(i);
				if(--inDegree[next] == 0) {
					q.add(next);
					res[next] = res[cur] + 1;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(res[i]).append(" ");
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}

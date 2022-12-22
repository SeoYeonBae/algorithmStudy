package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_2252_줄세우기 {

	static int N, M;
	static List<Integer>[] line;
	static int[] degree;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 줄을 세우기 위한 자료구조
		line = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			line[i] = new ArrayList<>();
		}

		// 진입 차수 저장
		degree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			degree[i] = 0;
		}

		// 줄 세우기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[a].add(0, b);
			degree[b]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		// 차수가 0인 애들 먼저 탐색
		for (int i = 1; i <= N; i++) {
			if(degree[i] == 0)
				q.offer(i);
		}
		
		visit = new boolean[N + 1];
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(visit[cur])	// 이미 출력에 더한 애는 패스
				continue;

			sb.append(cur).append(" ");
			visit[cur] = true;
			
			for(int i : line[cur]) {
				// 진입 차수를 감소했는데 0이 되는 애들만 다시 큐에 넣어줌
				if(--degree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

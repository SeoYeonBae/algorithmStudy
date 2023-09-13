package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2458_키순서 {

	static class Student{
		int taller;
		int shorter;
	}
	
	static int N, M;
	static List<Integer>[] adj;
	static Student[] counting;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N + 1];
		counting = new Student[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			counting[i] = new Student();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
		
		System.out.println(countStudent());
	}
	private static int countStudent() {
		int res = 0;
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			Arrays.fill(visited, false);
			visited[i] = true;
			q.offer(i);
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int num : adj[cur]) {
					if(visited[num])
						continue;
					visited[num] = true;
					q.add(num);
					counting[i].taller++;
					counting[num].shorter++;
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if(counting[i].taller + counting[i].shorter == N - 1)
				res++;
		}
		return res;
	}
}

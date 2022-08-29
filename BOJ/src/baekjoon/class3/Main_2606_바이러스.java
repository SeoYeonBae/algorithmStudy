package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_2606_바이러스 {

	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}

	static Node[] adjList;
	static Queue<Integer> q;
	static boolean[] visited;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()) + 1;
		int M = Integer.parseInt(br.readLine());

		adjList = new Node[N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		visited = new boolean[N];
		dfs(1);		// 76ms
		System.out.println("res : " + res);
		res = 0;
		visited = new boolean[N];
		q = new ArrayDeque<>();
		bfs(1);		// 80ms
		System.out.println(res);
	}

	private static void dfs(int v) {
		visited[v] = true;
		for(Node tmp = adjList[v]; tmp != null; tmp = tmp.next) {
			if(!visited[tmp.vertex]) {
				res++;
				dfs(tmp.vertex);
			}
		}
	}
	
	private static void bfs(int v) {
		q.offer(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int num = q.poll();
			for (Node tmp = adjList[num]; tmp != null; tmp = tmp.next) {
				if(!visited[tmp.vertex]) {
					res++;
					visited[tmp.vertex] = true;
					q.offer(tmp.vertex);
				}
			}
		}
	}
	
}

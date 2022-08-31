package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
	}
	
	static Node[] adjList;
	static int N, M;
	static boolean[] visited;
	static int res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjList = new Node[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		
		res = 0;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				res++;
			}
		}
		
		System.out.println(res);
	}
	private static void dfs(int i) {
		visited[i] = true;
		
		for (Node tmp = adjList[i]; tmp != null; tmp = tmp.next) {
			if(!visited[tmp.vertex]) {
				dfs(tmp.vertex);
			}
		}
		
	}
}

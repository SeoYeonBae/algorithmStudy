package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1753_최단경로 {

	static class Node{
		int no, weight;
		Node next;
		public Node(int no, int weight, Node next) {
			super();
			this.no = no;
			this.weight = weight;
			this.next = next;
		}		
	}
	
	static class Vertex{
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}
		
	}
	
	static int V, E, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수

		K = Integer.parseInt(br.readLine()); // 시작 정점

		int[] D = new int[V+1];
		boolean[] visited = new boolean[V+1];
		Node[] adjList = new Node[V+1];
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>(new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return o1.weight - o2.weight;
			}
			
		});
		
		Arrays.fill(D, Integer.MAX_VALUE);
		D[K] = 0;
		pQueue.offer(new Vertex(K, 0));
		
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from] = new Node(to, weight, adjList[from]);
		}
		
		while(!pQueue.isEmpty()) {
			Vertex vertex = pQueue.poll();
			visited[vertex.no] = true;
			
			for (Node node = adjList[vertex.no]; node != null; node = node.next) {
				if(!visited[node.no] && D[node.no] > D[vertex.no] + node.weight) {
					D[node.no] = D[vertex.no] + node.weight;
					pQueue.offer(new Vertex(node.no, D[node.no]));
				}
			}
		}
		
		for(int i = 1; i < V + 1; i++) {
			if(D[i] < Integer.MAX_VALUE)
				sb.append(D[i]).append("\n");
			else
				sb.append("INF").append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

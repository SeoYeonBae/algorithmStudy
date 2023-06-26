package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결 {

	static class Node {
		int vertax, weight;
		Node next;

		public Node(int vertax, Node next, int weight) {
			this.vertax = vertax;
			this.next = next;
			this.weight = weight;
		}
	}
	
	static class Vertax {
		int no, weight;
		
		public Vertax(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		Node[] adjList = new Node[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adjList[a] = new Node(b, adjList[a], c);
			adjList[b] = new Node(a, adjList[b], c);
		}
		
		boolean[] visited = new boolean[N + 1];
		int[] minEdge = new int[N + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[1] = 0;
		int result = 0;
		int cnt = 0;
		
		PriorityQueue<Vertax> pq = new PriorityQueue<>((v1, v2) -> v1.weight - v2.weight);
		pq.offer(new Vertax(1, minEdge[1]));
		
		while(true) {
			Vertax minVertax = pq.poll();
			
			if(visited[minVertax.no])
				continue;
			
			visited[minVertax.no] = true;
			result += minVertax.weight;
			if(++cnt == N)
				break;
			
			for(Node n = adjList[minVertax.no]; n != null; n = n.next) {
				if(!visited[n.vertax] && minEdge[n.vertax] > n.weight) {
					minEdge[n.vertax] = n.weight;
					pq.offer(new Vertax(n.vertax, minEdge[n.vertax]));
				}
			}
		}
		
		System.out.println(result);
				
	}
}

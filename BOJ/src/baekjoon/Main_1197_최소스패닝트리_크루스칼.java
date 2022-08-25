package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리_크루스칼 {

	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	static int V, E;
	static int[] parents;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()) + 1;
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		parents = new int[V];
		for (int i = 1; i < V; i++) {
			parents[i] = i;
		}
		
		Arrays.sort(edgeList);
		
		int result = 0;
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				result += e.weight;
			}
		}
		
		System.out.println(result);
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
		
	}

}

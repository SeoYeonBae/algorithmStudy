package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {	// 작은 간선부터 연결하기 위해 간선순으로 정렬
			return this.weight - o.weight;
		}

	}

	static int[] parents;
	static int V, E;
	static Edge[] edgeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edgeList[i] = new Edge(a, b, c);
		}
		
		// 크루스칼 이용
		make();
		Arrays.sort(edgeList);
		
		int res = 0;
		int cnt = 0;
		for (Edge e : edgeList) {
			if(union(e.from, e.to)) {
				res += e.weight;
				if(cnt == V - 1)	// 다 연결되면 간선의 수 = 정점 - 1개
					break;
			}
		}
		
		System.out.println(res);
	}

	private static void make() {
		parents = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int v) {
		if (parents[v] == v)
			return v;
		else
			return parents[v] = find(parents[v]);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

}

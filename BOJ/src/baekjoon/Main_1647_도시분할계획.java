package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획 {

	static class Node implements Comparable<Node>{
		int from, to, weight;
		
		Node(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node n) {
			return this.weight - n.weight;
		}
		
		
	}
	
	static int N, M;
	static int[] parents;
	static Node[] nodeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(N == 2) {
			System.out.println(0);
			return;
		}
		
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		nodeList = new Node[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			nodeList[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(nodeList);
		
		int res = 0;
		int cnt = 0;
		for (Node node : nodeList) {
			if(union(node.from, node.to)) {
				res += node.weight;
				cnt++;
				if(cnt == N - 2)
					break;
			}
		}
		System.out.println(res);
	}
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b)
			return false;
		
		if(a < b)
			parents[b] = a;
		else
			parents[a] = b;
		
		return true;
	}
	private static int find(int a) {
		if(parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}
}

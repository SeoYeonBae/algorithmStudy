package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {

	static int N, res;
	static List<List<Node>> list;
	static boolean[] visit;
	static class Node {
		int num;
		int weight;
		
		public Node (int num, int weight){
			this.num = num;
			this.weight = weight;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, w));
			list.get(b).add(new Node(a, w));
		}
		
		res = 0;
		for (int i = 1; i <= N; i++) {
			visit = new boolean[N + 1];
			visit[i] = true;
			dfs(i, 0);
		}
		System.out.println(res);
	}
	private static void dfs(int v, int sum) {
		for(Node node : list.get(v)) {
			if(!visit[node.num]) {
				visit[node.num] = true;
				dfs(node.num, sum + node.weight);
			}
		}
		res = Math.max(res, sum);
	}
	
}

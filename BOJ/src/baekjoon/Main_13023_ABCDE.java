package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13023_ABCDE {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}

	static Node[] adjList;
	static boolean[] visited;
	static int res, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N];

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);	// 양방향 그래프
			adjList[to] = new Node(from, adjList[to]);
		}

		for (int i = 0; i < M; i++) {
			visited = new boolean[N];
			dfs(i, 0);
			if(res == 1)	// 친구 관계가 있는 그래프는 탐색 안 해도 됨
				break;			
		}

		System.out.println(res);
	}

	private static void dfs(int v, int depth) {
//		System.out.println("v : " + v + " depth : " + depth);
		
		if (depth == 4) {	// 친구 관계 이미 찾은 후면 더 볼 필요 없이 리턴
			res = 1;
			return;
		}

		visited[v] = true;
		
		for (Node temp = adjList[v]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) {
				dfs(temp.to, depth + 1);
				visited[temp.to] = false;		// 사용하고 돌려놔야 경로 재탐색 가능
			}
		}

	}

}

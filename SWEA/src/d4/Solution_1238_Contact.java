package d4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_Contact {

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	static Node[] adjust;
	static int max, res, N, V;
	static int[] visited;
	static Queue<Integer> q;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			adjust = new Node[N];
			visited = new int[N];
			q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), " ");
			int from, to;
			while (st.hasMoreTokens()) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjust[from] = new Node(to, adjust[from]);
			}
			contactbfs(V);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
			max = 0;
			res = 0;
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void contactbfs(int v) {
		q.offer(v);
		visited[v] = 1;

		while (!q.isEmpty()) { // 그래프 bfs로 탐색
			int cur = q.poll();
			Node tmp = adjust[cur];
			
			while (tmp != null) {
				if (visited[tmp.to] == 0) {
					q.offer(tmp.to);
					visited[tmp.to] = visited[cur] + 1; // 가장 마지막 열을 확인하기 위해 count 변수를 하나 두었음
					max = visited[tmp.to];
				}
				tmp = tmp.next;
			}
		}

		for (int i = 0; i < N; i++) {
			if (visited[i] == max && res < i)  // 방문한 곳의 count 값이 마지막 count 값과 같을 때 큰 값 찾음
				res = i;
		}

	}

}

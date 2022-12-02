package topology;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
	static class Node {
		int vertex;
		Node next;

		public Node(int vertex, Node next) {
			this.vertex = vertex;
			this.next = next;
		}
	}

	private static int V, E;
	private static Node[] adjList;
	private static int[] inDegree;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new Node[V + 1]; // 각 정점별 인접리스트
		inDegree = new int[V + 1]; // 정점별 진입차수

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 무향 그래프 처리
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;

		}
		ArrayList<Integer> list = topologySort();
		if (list.size() == V) {
			System.out.println(list);
		} else {
			System.out.println("사이클 발생");
		}
	}

	private static ArrayList<Integer> topologySort() {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i < V + 1; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int cur = q.poll();
			list.add(cur);

			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (--inDegree[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}
		}
		return list;
	}

}

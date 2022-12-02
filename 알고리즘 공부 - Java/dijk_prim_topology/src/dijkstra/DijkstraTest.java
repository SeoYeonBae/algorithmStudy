package dijkstra;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());

		int[][] adjMatrix = new int[V][V];

		for (int i = 0; i < V; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// start -> end로의 최단경로
		int start = 0; // 출발 정점
		int end = V - 1; // 도착 정점
		// 다익스트라 알고리즘에 필요한 자료구조
		int[] D = new int[V]; // 출발지에서 자신으로 오는데 소요되는 최소비용
		boolean[] visited = new boolean[V]; // 처리한 정점 여부

		Arrays.fill(D, Integer.MAX_VALUE);
		// 출발 정점 처리
		D[start] = 0;

		int min, minVertex;

		for (int i = 0; i < V; i++) {
			// Step 1. 미방문 정점 중 출발지에서 자신으로의 비용이 최소인 정점 선택
			// 방문해야하는 정점 중 출발지에서 가장 가까운 정점 찾기
			min = Integer.MAX_VALUE;
			minVertex = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > D[j]) {
					min = D[j];
					minVertex = j;
				}
			}

			// Step 2. 방문처리
			visited[minVertex] = true;
//			if (minVertex == end) break;	// 문제가 start -> end로의 최단거리이면 탈출!

			// Step 3. 선택된 정점을 경유지로 해서 미방문 정점들로 가는 비용을 따져보고 기존 최적해보다 유리하면 갱신
			// !visited[j] 방문했던 곳은 방문 안 함
			// adjMatrix[minVertex][j] > 0 방문 가능한 곳인지 판별 현재 input이 0이면 갈 수 없는 경로인 input이기 때문에 이렇게 판별
			// D[j] > D[minVertex] + adjMatrix[minVertex][j] 기존 비용 > 거쳐가는 비용 이라면 거쳐가는 비용으로 갱신하기 위해 판별
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[minVertex][j] > 0 && D[j] > D[minVertex] + adjMatrix[minVertex][j]) {
					D[j] = D[minVertex] + adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(Arrays.toString(D));
		System.out.println(D[end]);
	}
}

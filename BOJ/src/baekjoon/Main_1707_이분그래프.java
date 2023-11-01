package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main_1707_이분그래프 {

	
	static int V, E;
	static int[] visit;
	static List<List<Integer>> numbers;
	static boolean isBipartite;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			numbers = new ArrayList<>();
			for (int i = 0; i <= V; i++) {
				numbers.add(new ArrayList<>());
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				numbers.get(a).add(b);
				numbers.get(b).add(a);
			}
			
			isBipartite = true;
			visit = new int[V + 1];
			for (int i = 1; i <= V; i++) {
				if(visit[i] == 0) {	// 방문하지 않은 노드의 인접 노드를 방문하며 확인해봄
					if(!bfs(i)) {
						break;
					}
				}
			}
			
			if(isBipartite)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");
				
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	private static boolean bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		visit[n] = 1;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for (int i : numbers.get(cur)) {
				if(visit[i] == 0) {	// 방문 안 했으면 나랑 반대로
					visit[i] = visit[cur] * -1;
					q.add(i);
				}
				if(visit[cur] == visit[i]) {	// 인접한 노드가 나랑 같은 색
					isBipartite = false;
					return false;
				}
			}
		}
		return true;
	}


}

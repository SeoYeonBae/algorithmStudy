package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12869_뮤탈리스크 {

	static int N;
	static int[] scv;
	static boolean[][][] visited;
	// 뮤탈리스크의 공격 방법 순열
	static int[][] attack = {
			{9, 3, 1},	
			{9, 1, 3},	
			{3, 9, 1},	
			{3, 1, 9},	
			{1, 9, 3},	
			{1, 3, 9}	
	};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		scv = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		// 해당 체력을 가졌을 때 공격했는지의 여부 판단
		visited = new boolean[61][61][61];
		bfs();
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {scv[0], scv[1], scv[2], 0});
		visited[scv[0]][scv[1]][scv[2]] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int s = cur[0];
			int c = cur[1];
			int v = cur[2];
			int cnt = cur[3];
			
			// scv가 모든 체력을 소진했다면 공격횟수 출력하고 종료 
			if(s == 0 && c == 0 && v == 0) {
				System.out.println(cnt);
				return;
			}
			
			// 하나씩 공격해보고 체력이 0 미만으로 떨어지면 0으로 고정
			for (int i = 0; i < 6; i++) {
				int ns = s - attack[i][0] >= 0 ? s - attack[i][0] : 0;
				int nc = c - attack[i][1] >= 0 ? c - attack[i][1] : 0;
				int nv = v - attack[i][2] >= 0 ? v - attack[i][2] : 0;
				
				// 이미 때렸던 조합이면 무시
				if(visited[ns][nc][nv])
					continue;
				
				visited[ns][nc][nv] = true;
				q.offer(new int[] {ns, nc, nv, cnt + 1});
			}
			
		}
	}
}

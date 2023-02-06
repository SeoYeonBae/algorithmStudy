package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main_14226_이모티콘 {

	static int S, res;
	static int[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		res = Integer.MAX_VALUE;
		visited = new int[1002][1002];
		for (int i = 0; i < 1002; i++) {
			Arrays.fill(visited[i], -1);
		}
		bfs();
		for (int i = 0; i < 1002; i++) {
			if(visited[S][i] != -1)
				res = Math.min(res, visited[S][i]);
		}
		System.out.println(res);
	}
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		// 화면에 있는 이모티콘의 수, 클립보드에 있는 이모티콘의 수
		q.add(new int[] {1, 0});
		visited[1][0] = 0;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int monitor = cur[0];
			int clip = cur[1];
		
			if(monitor == S)
				return;
			
			// 화면에 있는 이모티콘을 모두 복사해 클립보드에 저장
			if(visited[monitor][monitor] == -1) {
				q.add(new int[] {monitor, monitor});
				visited[monitor][monitor] = visited[monitor][clip] + 1;
			}
			// 클립보드에 있는 모든 이모티콘 붙여넣기
			if(clip != 0 && monitor + clip < 1002 && visited[monitor + clip][clip] == -1) {
				q.add(new int[] {monitor + clip, clip});
				visited[monitor + clip][clip] = visited[monitor][clip] + 1;
			}
			// 화면에 있는 이모티콘 하나 삭제
			if(monitor - 1 >= 0 && visited[monitor - 1][clip] == -1) {	
				q.add(new int[] {monitor - 1, clip});
				visited[monitor - 1][clip] = visited[monitor][clip] + 1;
			}
			
		}
	}
}

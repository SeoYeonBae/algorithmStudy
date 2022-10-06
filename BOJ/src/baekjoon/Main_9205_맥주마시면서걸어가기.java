package baekjoon;

import java.io.*;
import java.util.*;

public class Main_9205_맥주마시면서걸어가기 {

	static int startR, startC, festivalR, festivalC;
	static boolean[] visited;
	static int[][] store;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());	// 시작 위치
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			
			store = new int[n][2];	// 편의점 위치
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());	// 최종 목표
			festivalR = Integer.parseInt(st.nextToken());
			festivalC = Integer.parseInt(st.nextToken());
			
			visited = new boolean[n];	// 편의점 방문 체크 배열
			if(bfs())
				sb.append("happy\n");
			else
				sb.append("sad\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	private static boolean bfs() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {startR, startC});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			// 50m에 한 병인데 20개짜리 맥주 한 박스 들고 다니니까 50*20 = 1000
			if(Math.abs(festivalR - r) + Math.abs(festivalC - c) <= 1000)	// 현재 위치에서 축제 갈 수 있으면 바로 리턴
				return true;
			
			for (int i = 0; i < store.length; i++) {	// 축제 못 가서 편의점 가야 되는 경우
				if(visited[i])	// 이미 방문한 편의점 무시
					continue;
				
				int sr = store[i][0];	// 편의점 좌표
				int sc = store[i][1];
				
				if(Math.abs(r - sr) + Math.abs(c - sc) > 1000)	// 갈 수 없는 편의점이면 무시
					continue;
				
				visited[i] = true;
				q.offer(new int[] {sr, sc});	// 편의점 들려서 맥주 사고 여기서부터 다시 시작
			}
				
		}
		return false;
	}
}

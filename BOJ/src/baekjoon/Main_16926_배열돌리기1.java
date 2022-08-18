package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		int N  = Integer.parseInt(st.nextToken());		// 행
		int M  = Integer.parseInt(st.nextToken());		// 열
		int R  = Integer.parseInt(st.nextToken());		// 회전해야 하는 수
		
		int[][] map = new int[N][M];					// 배열 초기화
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int rec = Math.min(N, M) / 2;					// 돌려야 하는 내부 사각형 수

		int[] dr = {0, 1, 0, -1};						// 시작점 기준으로 우하좌상
		int[] dc = {1, 0, -1, 0};
		int nr, nc;
		
		for(int i = 0; i < R; i++) {					// R만큼 반복
			for(int j = 0; j < rec; j++) {				// 내부 사각형 개수만큼 반복

				int r = j, c = j;						// 가장 왼쪽 위에 있는 곳에서 시작
				int d = 0;
				int tmp = map[r][c];
				
				while(d < 4) {
					nr = r + dr[d];
					nc = c + dc[d];
					
					if(nr < j || nr >= N-j || nc < j || nc >= M-j) {
						d += 1;
					}
					else {
						map[r][c] = map[nr][nc];
						r = nr;
						c = nc;
					}
				}
				
				map[j + 1][j] = tmp;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				sb.append(map[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
}

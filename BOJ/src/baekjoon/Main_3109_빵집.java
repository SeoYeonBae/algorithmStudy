package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_3109_빵집 {

	static int R, C, res;
	static char[][] map;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	static boolean isConnect;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for(int i = 0; i < R; i++) {
			isConnect = false;	// 파이프 연결하러 가기 아직 연결 안 했으니까 false
			pipe(i, 0);
			
		}
		
		System.out.println(res);
	}

	private static void pipe(int r, int c) {
		int nr, nc;

		for(int d = 0; d < 3; d++) {
			nr = r + dr[d];
			nc = c + dc[d];

			if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != '.')	// 범위 밖 OR 방문했던 곳 OR 건물이라면 다른 칸 찾아보기 
				continue;
			
			if(isConnect)	// 이미 마지막까지 파이프를 연결했다면 다른 탐색 하지 않고 첫 열로 백트래킹하기 위한 변수
				return;
			
			map[nr][nc] = '#';	// 위에서 다 안 걸렸다면 연결할 수 있는 곳이기 때문에 방문 표시

			if(nc == C - 1) {	// 마지막 열까지 갔다면
				res++;			// 결과 +1
				isConnect = true;	// 마지막 열까지 갔다는 것을 표시 
				return;
			}

			pipe(nr, nc);	// 방문했던 곳에서 다시 탐색
		}
	}
}

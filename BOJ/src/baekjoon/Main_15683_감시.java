package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_15683_감시 {

	static int[] dr = { 0, -1, 0, 1 }; // 우상좌하
	static int[] dc = { 1, 0, -1, 0 };
	static int[][] map, tmp;
	static int N, M, ans, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		tmp = new int[N][M];
		int num;
		boolean flag = true; // CCTV가 아예 없는 경우를 위한 flag 변수
		for (int i = 0; i < N; i++) { // 맵 초기화
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				num = Integer.parseInt(st.nextToken());
				if (num != 0)
					flag = false; // CCTV가 있으면 flag = false
				map[i][j] = num;
				
			}
		}

		if (!flag) { // CCTV가 있을 때만 탐색을 함
			
			copyMap(); 	// 우선 map 복사
			
			min = N * M;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					switch (map[i][j]) {
					case 1:
						for (int d = 0; d < 4; d++) {
							System.out.println("--------------" + d + "-------------");
							cctv(i, j, d);
							
							for (int r = 0; r < N; r++) {
								for (int c = 0; c < M; c++)
									System.out.print(tmp[r][c] + " ");
								System.out.println();
							}
							
							if( min > cnt0())	// 0 세어 보고 수가 제일 작으면 원래 map에 tmp를 복사함
								copyTmp();					
						}
						break;
					case 2:

						break;
					case 3:

						break;
					case 4:

						break;
					case 5:

						break;

					default:
						break;
					}
				}
			}
			
		}

		System.out.println(ans);

		
	}
	// CCTV 가동
	private static void cctv(int r, int c, int d) {
		
		while(true) {
			r += dr[d];
			c += dc[d];
			System.out.println(r + " " + c + " " + d);
			
			if (r < 0 || r >= N || c < 0 || c >= M || tmp[r][c] == 6) // 범위 밖 or 벽을 만나면 끝내기
				return;
			
			if (tmp[r][c] != 0) // CCTV는 점프
				continue;
			
			tmp[r][c] = -1;	// 방문했다는 표시
			
		}
	}

	// 맵에서 0을 세어 보고 (= 사각지대를 찾고) 그 값을 반환  
	private static int cnt0() {
		int cnt = 0;
		
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if(tmp[i][j] == 0)
					cnt++;
		
		return cnt;
	}
	
	// 최솟값을 주는 cctv 방향을 저장했던 tmp 배열을 원래 배열에 복사
	private static void copyTmp() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				map[i][j] = tmp[i][j];	
	}
	// 최솟값 못 찾으면 tmp를 다시 돌려놓음
	private static void copyMap() {
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) 
				tmp[i][j] = map[i][j];	
	}

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20056_마법사상어와파이어볼 {

	static int N, M, K;
	static List<FireBall>[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static class FireBall{
		int r, c, m, s, d;

		public FireBall(int r, int c, int m, int s, int d) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			FireBall ball = new FireBall(r, c, m, s, d);
			map[r][c].add(ball);
		}
		
		
		for (int tc = 0; tc < K; tc++) {
			move();
			combine();
		}
		
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (FireBall b : map[i][j]) {
					res += b.m;
				}
			}
		}
		System.out.println(res);
		
	}
	private static void combine() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() < 2)
					continue;
				
				int nm = 0;
				int ns = 0;
				int nd = 0;
				int cntOdd = 0;	// 파이어볼의 방향이 모두 홀수이거나 짝수인지 판별하기 위함
				int cntEven = 0;
				
				for (FireBall ball : map[i][j]) {
					nm += ball.m;
					ns += ball.s;
					if(ball.d % 2 == 1)
						cntOdd++;
					else
						cntEven++;
				}
				
				// 나누어진 파이어볼의 질량, 속력, 방향
				nm /= 5;	
				if(nm == 0) {
					map[i][j].clear();
					continue;
				}
				ns /= map[i][j].size();
				if(cntOdd != map[i][j].size() && cntEven != map[i][j].size())
					nd = 1;
				
				map[i][j].clear();
				for (int k = 0; k < 8; k += 2) {
					map[i][j].add(new FireBall(i, j, nm, ns, nd + k));
				}
			}
		}
	}
	private static void move() {
		List<FireBall>[][] tmp = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j].size() == 0)
					continue;
				
				for (FireBall ball : map[i][j]) {
					int nr = ball.r;
					int nc = ball.c;
					int s = ball.s;
					int d = ball.d;
					
					for (int speed = 0; speed < s; speed++) {
						nr += dr[d];
						nc += dc[d];
						
						if(nr == N) nr = 0;
						else if(nr == -1) nr = N - 1;
						if(nc == N) nc = 0;
						else if(nc == -1) nc = N - 1;
					}
					
					ball.r = nr;
					ball.c = nc;
					tmp[nr][nc].add(ball);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			map[i] = tmp[i].clone();
		}
	}
}

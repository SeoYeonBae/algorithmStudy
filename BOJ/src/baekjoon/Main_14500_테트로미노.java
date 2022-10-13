package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14500_테트로미노 {

	static int N, M, ans, res;
	static int[][] map;
	static int[][][] tetromino = {
			{{0,0}, {0,1}, {0,2}, {0,3}},	// ㅡ
			{{0,0}, {1,0}, {2,0}, {3,0}},
			{{0,0}, {1,0}, {0,1}, {1,1}},	// ㅁ
			{{0,0}, {1,0}, {2,0}, {2,1}},	// ㄴ
			{{0,0}, {1,0}, {2,0}, {2,-1}},
			{{0,0}, {0,1}, {1,0}, {2,0}},
			{{0,0}, {0,1}, {1,1}, {2,1}},
			{{0,0}, {0,1}, {0,2}, {-1,2}},
			{{0,0}, {1,0}, {1,1}, {1,2}},
			{{0,0}, {1,0}, {0,1}, {0,2}},
			{{0,0}, {0,1}, {0,2}, {1,2}},
			{{0,0}, {1,0}, {1,1}, {2,1}},	// ㄹ
			{{0,0}, {1,0}, {1,-1}, {2,-1}},
			{{0,0}, {0,1}, {-1,1}, {-1,2}},
			{{0,0}, {0,1}, {1,1}, {1,2}},
			{{0,0}, {0,1}, {0,2}, {1,1}},	// ㅜ
			{{0,0}, {-1,1}, {0,1}, {1,1}},
			{{0,0}, {0,1}, {0,2}, {-1,1}},
			{{0,0}, {1,0}, {2,0}, {1,1}}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = -1;
		for (int i = 0; i < 19; i++) {
			go(i);
			ans = Math.max(ans, res);
		}
		System.out.println(ans);
		br.close();
	}

	private static void go(int num) {
		res = 0;
		for (int i = 0; i < N; i++) {	// 각 맵 위치에서 블럭 하나씩 둬보기
			for (int j = 0; j < M; j++) {
				int cnt = 0;
				for (int t = 0; t < 4; t++) {
					int nr = i + tetromino[num][t][0];
					int nc = j + tetromino[num][t][1];
					
					if(nr < 0 || nr >= N || nc < 0 || nc >= M) {
						cnt = 0;
						break;
					}
					cnt += map[nr][nc];
				}
				res = Math.max(res, cnt);
			}
		}
		
	}
}

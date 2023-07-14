package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14712_넴모넴모 {

	static int N, M, res;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][M + 1];
		res = 1;
		nemmo(1, 1);
		System.out.println(res);
	}

	private static void nemmo(int r, int c) {
		if(r == N + 1)	// 입력 받은 행이 범위를 벗어났다면 탐색이 끝난 것
			return;
		
		int nr, nc;
		if (c == M) {	// 다음 행으로
			nr = r + 1;
			nc = 1;
		} else {		// 다음 열로
			nr = r;
			nc = c + 1;
		}

		nemmo(nr, nc);	// (r, c)에 넴모를 놓지 않고 다음 칸으로 갔을 때
		
		// 위, 왼, 왼쪽 대각선위 중 하나라도 비어있으면 넴모 놓기 가능
		if (!map[r - 1][c] || !map[r][c - 1] || !map[r - 1][c - 1]) {
			map[r][c] = true;
			res++;
			nemmo(nr, nc);
			map[r][c] = false;
		}
	}
}

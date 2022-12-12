package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3085_사탕게임 {

	static int N, max;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		max = Integer.MIN_VALUE;
		int idx = 0;
		// 안 바꾼 게 최선일 수도 있으니까 안 바꾼 상태에서 먹어봄
		// 최대가 N의 값이므로 N 찾으면 더 이상 안 해도 됨
		while(max != N && idx < N) {
			eat(idx, idx);
			idx++;
		}
		
		// 열부터 차례대로 살펴서 바꾸고 먹어봄
		// 달랐을 때만 칸을 바꾸고 다시 먹어봄
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if(map[i][j] != map[i][j + 1]) {
					swap(i, j, i, j + 1);
					eat(i, j);
					eat(i, j + 1);
					swap(i, j, i, j + 1);
				}
			}
			if(max == N)
				break;
		}
		
		// 행에서도 바꾸고 먹어봄
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if(map[j][i] != map[j + 1][i]) {
					swap(j, i, j + 1, i);
					eat(j, i);
					eat(j + 1, i);
					swap(j, i, j + 1, i);
				}
			}
			if(max == N)
				break;
		}
		
		System.out.println(max);
	}

	private static void swap(int r, int c, int r2, int c2) {
		char tmp = map[r][c];
		map[r][c] = map[r2][c2]; 
		map[r2][c2] = tmp;
	}

	private static void eat(int r, int c) {
		int tmpMax = 1;
		int tmp = 1;

		// 행 확인
		for (int i = 0; i < N - 1; i++) {
			if (map[i][c] == map[i + 1][c])
				tmp++;
			else {
				tmpMax = Math.max(tmpMax, tmp);
				tmp = 1;
			}
		}
		tmpMax = Math.max(tmpMax, tmp);
		
		// 열 확인
		tmp = 1;
		for (int i = 0; i < N - 1; i++) {
			if (map[r][i] == map[r][i + 1])
				tmp++;
			else {
				tmpMax = Math.max(tmpMax, tmp);
				tmp = 1;
			}
		}
		tmpMax = Math.max(tmpMax, tmp);

		max = Math.max(tmpMax, max);
	}

}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {

	static int[][] wheel, copy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		wheel = new int[5][8];
		for (int i = 1; i < 5; i++) {
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int wNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			// 입력받은 대로 톱니부터 회전
			copy = new int[5][8];
			roll(wNum, dir);

			int newDir = dir;
			// 입력받은 톱니로부터 오른쪽으로 검사
			for (int j = wNum + 1; j <= 4; j++) {
				if (wheel[j - 1][2] != wheel[j][6]) {
					newDir *= -1;
					roll(j, newDir);
				} else {
					for (int k = j; k <= 4; k++) {
						System.arraycopy(wheel[k], 0, copy[k], 0, 8);
					}
					break;
				}
			}

			newDir = dir;
			// 입력받은 톱니로부터 왼쪽으로 검사
			for (int j = wNum - 1; j >= 0; j--) {
				if (wheel[j + 1][6] != wheel[j][2]) {
					newDir *= -1;
					roll(j, newDir);
				} else {
					for (int k = j; k >= 0; k--) {
						System.arraycopy(wheel[k], 0, copy[k], 0, 8);
					}
					break;
				}
			}

			for (int j = 1; j < 5; j++) {
				System.arraycopy(copy[j], 0, wheel[j], 0, 8);
			}
		}

		int res = 0;
		int[] score = { 0, 1, 2, 4, 8 };
		for (int i = 1; i < 5; i++) {
			if (wheel[i][0] == 1)
				res += score[i];
		}
		System.out.println(res);
	}

	private static void roll(int wNum, int dir) {
		if (dir == 1) { // 시계방향 회전
			int tmp = wheel[wNum][7];
			for (int i = 7; i > 0; i--) {
				copy[wNum][i] = wheel[wNum][i - 1];
			}
			copy[wNum][0] = tmp;
		} else { // 반시계방향 회전
			int tmp = wheel[wNum][0];
			for (int i = 0; i < 7; i++) {
				copy[wNum][i] = wheel[wNum][i + 1];
			}
			copy[wNum][7] = tmp;
		}
	}
}

package baekjoon;

import java.io.*;
import java.util.Arrays;

public class Main_16113_시그널 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int M = N / 5;	// 가로, 세로는 5로 고정
		
		char[] input = br.readLine().toCharArray();
		int index = 0;
		char[][] numbers = new char[5][M];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < M; j++) {
				numbers[i][j] = input[index++];
			}
		}

		index = 0;
		boolean isOne = true;
		while (index < M) {	// 가로의 끝까지 검사
			if (numbers[0][index] == '#') {	// 숫자 모두 좌상단은 검은색
				isOne = true;
				if (numbers[1][index] == '.') { // 2, 3, 7
					isOne = false;
					if (numbers[2][index] == '.')
						sb.append("7");
					else {
						if (numbers[3][index] == '#')
							sb.append("2");
						else
							sb.append("3");
					}
				} else { // 0, 1, 4, 5, 6, 8, 9
					if (numbers[3][index] == '.') { // 4, 5, 9
						isOne = false;
						if (numbers[4][index] == '.')
							sb.append("4");
						else {
							if (numbers[1][index + 2] == '.')
								sb.append("5");
							else
								sb.append("9");

						}
					} else { // 0, 1, 6, 8
						if (index + 1 < M) {
							for (int i = 0; i < 5; i++) {
								if (numbers[i][index + 1] != '.') {
									isOne = false;
									break;
								}
							}
						}
						if (isOne) {
							sb.append("1");
						} else { // 0, 6, 8
							if (numbers[2][index + 1] == '.')
								sb.append("0");
							else {
								if (numbers[1][index + 2] == '.')
									sb.append("6");
								else
									sb.append("8");
							}
						}
					}
				}
				if (isOne)
					index += 2;	// 1은 1 한줄 + 여백 한줄
				else
					index += 4;	// 다른 숫자들은 숫자 3줄 + 여백 한줄
			} else
				index++;	// 여백이라면 다음 세로줄 검사
		}

		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}

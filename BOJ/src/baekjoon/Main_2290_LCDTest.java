package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2290_LCDTest {

	static char[][] output;
	static int index, width, length, half;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		char[] input = st.nextToken().toCharArray();
		br.close();

		output = new char[(2 * s) + 3][(s + 3) * input.length];
		for (int i = 0; i < (2 * s) + 3; i++) {
			for (int j = 0; j < (s + 3) * input.length; j++) {
				output[i][j] = ' ';
			}
		}
		index = 0;
		length = (2 * s) + 2;
		half = length / 2;
		for (int i = 0; i < input.length; i++) {
			width = index + s + 1;
			int number = Character.getNumericValue(input[i]);
			switch (number) {
			case 0:
				horizontal(true, false, true);
				vertical(true, true, true, true);
				break;
			case 1:
				vertical(false, true, false, true);
				break;
			case 2:
				horizontal(true, true, true);
				vertical(false, true, true, false);
				break;
			case 3:
				horizontal(true, true, true);
				vertical(false, true, false, true);
				break;
			case 4:
				horizontal(false, true, false);
				vertical(true, true, false, true);
				break;
			case 5:
				horizontal(true, true, true);
				vertical(true, false, false, true);
				break;
			case 6:
				horizontal(true, true, true);
				vertical(true, false, true, true);
				break;
			case 7:
				horizontal(true, false, false);
				vertical(false, true, false, true);
				break;
			case 8:
				horizontal(true, true, true);
				vertical(true, true, true, true);
				break;
			case 9:
				horizontal(true, true, true);
				vertical(true, true, false, true);
				break;
			}
			index = index + s + 3;
		}
		for (int i = 0; i < (2 * s) + 3; i++) {
			for (int j = 0; j < (s + 3) * input.length; j++) {
				sb.append(output[i][j]);
			}
			sb.append("\n");
		}
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void vertical(boolean topLeft, boolean topRight, boolean bottonLeft, boolean bottomRight) {
		if (topLeft) {
			for (int i = 1; i < half; i++)
				output[i][index] = '|';
		}
		if (topRight) {
			for (int i = 1; i < half; i++)
				output[i][width] = '|';
		}
		if (bottonLeft) {
			for (int i = half + 1; i < length; i++)
				output[i][index] = '|';
		}
		if (bottomRight) {
			for (int i = half + 1; i < length; i++)
				output[i][width] = '|';
		}
	}

	private static void horizontal(boolean top, boolean middle, boolean bottom) {
		if (top) {
			for (int i = index + 1; i < width; i++)
				output[0][i] = '-';
		}
		if (middle) {
			for (int i = index + 1; i < width; i++)
				output[half][i] = '-';
		}
		if (bottom) {
			for (int i = index + 1; i < width; i++)
				output[length][i] = '-';
		}
	}
}

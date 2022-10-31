package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2309_일곱난쟁이 {
	
	static int[] numbers, input;
	static StringBuilder sb;
	static BufferedReader br;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		input = new int[9];	// 난쟁이 9명
		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);	// 오름차순으로 출력할 거니까 처음부터 정렬해서 조합 만듦
		numbers = new int[7];	// 최종 정답이 될 난쟁이 7명
		comb(0, 0);	// 9명 중에 7명 뽑는 조합
	}

	private static void comb(int start, int cnt) throws IOException {

		if(cnt == 7) {
			if(makeSum()) {	// 7명 뽑았으면 더해봄
				for (int i = 0; i < 7; i++) {
					sb.append(numbers[i]).append("\n");
				}
				br.close();
				bw.append(sb.toString());
				bw.flush();
				bw.close();
				System.exit(0);
			}
			return;
		}
		
		for (int i = start; i < 9; i++) {
			numbers[cnt] = input[i];
			comb(i + 1, cnt + 1);
		}
	}

	private static boolean makeSum() {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += numbers[i];
		}
		if(sum == 100)
			return true;
		else
			return false;
	}
}

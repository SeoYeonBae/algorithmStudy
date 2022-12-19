package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long S = Integer.parseInt(br.readLine()); // 만들어야 하는 수

		long N = 0; // S륾 만드는 N개의 자연수 최댓값
		long sum = 0;
		for (long i = 1; i <= S; i++) {
			sum += i;
			N++;
			if (sum > S) {	// 1부터 S까지 더한 숫자가 N을 초과하면 갯수 하나 줄임
				N--;
				break;
			}
		}
		
		System.out.println(N);
	}
}

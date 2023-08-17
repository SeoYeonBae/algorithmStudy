package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1339_단어수학 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] alphabet = new int[26];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				char c = input.charAt(j);
				alphabet[c - 65] += (int)Math.pow(10, input.length() - 1 - j);
			}
		}
		
		Arrays.sort(alphabet);
		
		int num = 9;
		int tc = 25;
		int res = 0;
		while (alphabet[tc] != 0) {
			res += alphabet[tc] * num;
			tc--;
			num--;
		}
		
		System.out.println(res);
	}
}

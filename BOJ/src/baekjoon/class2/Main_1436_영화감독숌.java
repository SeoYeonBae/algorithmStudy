package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int s = 666;
		int cnt = 1;
		while (cnt < N) {
			s += 1;
			if (String.valueOf(s).contains("666"))
				cnt++;
		}
		System.out.println(s);
	}
}

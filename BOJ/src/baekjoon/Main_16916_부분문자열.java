package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16916_부분문자열 {

	static String S, P;
	static int[] pi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = br.readLine();
		P = br.readLine();
		
		pi = new int[P.length()];
		getPi();
		System.out.println(kmp());
		
	}
	private static int kmp() {
		int j = 0;
		for (int i = 0; i < S.length(); i++) {
			while(j > 0 && S.charAt(i) != P.charAt(j))
				j = pi[j - 1];
			if(S.charAt(i) == P.charAt(j)) {
				if(j == P.length() -1)
					return 1;
				else
					j++;
			}
		}
		return 0;
	}
	private static void getPi() {
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j))
				j = pi[j - 1];
			if(P.charAt(i) == P.charAt(j))
				pi[i] = ++j;
		}
		
	}
}

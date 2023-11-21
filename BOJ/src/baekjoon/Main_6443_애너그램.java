package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main_6443_애너그램 {
	static StringBuilder sb;
	static String word;
	static int length;
	static boolean[] used;
	static int[] alpha;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			word = br.readLine();
			char[] cArray = word.toCharArray();
			alpha = new int[26];
			for(char c : cArray) {
				alpha[c - 'a']++;
			}
			word = new String(cArray);
			length = word.length();
			used = new boolean[length];
			anagram("", 0);
		}
		br.close();
		bw.append(sb);
		bw.flush();
		bw.close();
	}

	private static void anagram(String w, int cnt) {
		if(cnt == length) {
			sb.append(w).append("\n");
			return;
		}
		
		for (int i = 0; i < 26; i++) {
			if(alpha[i] > 0) {
				alpha[i]--;
				anagram(w + (char)(i + 'a'), cnt + 1);
				alpha[i]++;
			}
		}
	}

}

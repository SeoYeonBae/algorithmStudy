package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {

	static int L, C;
	static String[] alpha, pw;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		alpha = new String[C];
		for(int i = 0; i < C; i++)
			alpha[i] = st.nextToken();
		
		Arrays.sort(alpha);
		pw = new String[L];
		comb(0, 0, 0, 0);
		
		br.close(); 
		bw.append(sb.toString()); 
		bw.flush(); 
		bw.close(); 
	}
	private static void comb(int start, int cnt, int cons, int vowel) {
		if(cnt == L) {
			if(cons >= 2 && vowel >= 1) {
				for (int i = 0; i < L; i++) {
					sb.append(pw[i]);
				}
				sb.append("\n");
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			pw[cnt] = alpha[i];
			if(alpha[i].equals("a") || alpha[i].equals("e") || alpha[i].equals("i") || alpha[i].equals("o") || alpha[i].equals("u"))
				comb(i + 1, cnt + 1, cons, vowel + 1);
			else
				comb(i + 1, cnt + 1, cons + 1, vowel);
		}
	}
}

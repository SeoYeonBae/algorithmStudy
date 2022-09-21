package baekjoon.class4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	
	static int[] numbers;
	static int N, R;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[R];
		
		comb(0, 1);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void comb(int cnt, int start) {
		if(cnt == R) {
			for (int i = 0; i < R; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}

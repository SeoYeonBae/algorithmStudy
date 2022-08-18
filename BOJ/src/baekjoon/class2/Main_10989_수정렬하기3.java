package baekjoon.class2;

import java.io.*;
import java.util.Arrays;

public class Main_10989_수정렬하기3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] list = new int[N];
		for(int i = 0; i < N; i++)
			list[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(list);
		for(int i = 0; i < N; i++)
			sb.append(list[i]).append("\n");
		
		System.out.println(sb);
		br.close();
		
	}
}

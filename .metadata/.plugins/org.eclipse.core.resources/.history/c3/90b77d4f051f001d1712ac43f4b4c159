package baekjoon;

import java.io.*;

public class Main_3040_백설공주와일곱난쟁이 {

	static int[] dwarf, real;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		dwarf = new int[9];
		real = new int[7];
		for(int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0, 0);
		
		System.out.println(sb);
		br.close();
	}
	
	private static void comb(int cnt, int start, int sum) {
		if(cnt == 7) {
			if(sum == 100) {
				for(int i = 0; i < 7; i++)
					sb.append(real[i]).append("\n");
			}
			return;
		}
		
		for(int i = start; i < 9; i++) {
			real[cnt] = dwarf[i];
			comb(cnt + 1, i + 1, sum + dwarf[i]);
			
		}
	}
	
}

package baekjoon;

import java.io.*;

public class Main_2839_설탕배달 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int res = 0;
		while(N >= 0) {
			if(N % 5 == 0) {
				res += N / 5;
				break;
			}
			N -= 3;
			res++;
		}
		
		if(N < 0)
			res = -1;
		
		sb.append(res).append("\n");
		bw.append(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
		
	}
	
}

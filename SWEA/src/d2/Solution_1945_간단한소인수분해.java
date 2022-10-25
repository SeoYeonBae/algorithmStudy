package d2;

import java.io.*;
import java.util.*;

public class Solution_1945_간단한소인수분해 {

	static int a, b, c, d, e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;

			while(N != 1) {
				if(N % 2 == 0) {
					a++;
					N = N / 2;
				} else if(N % 3 == 0){
					b++;
					N = N / 3;
				} else if(N % 5 == 0){
					c++;
					N = N / 5;
				} else if(N % 7 == 0){
					d++;
					N = N / 7;
				} else if(N % 11 == 0){
					e++;
					N = N / 11;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(a).append(" ").append(b).append(" ").append(c).append(" ")
					.append(d).append(" ").append(e).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}

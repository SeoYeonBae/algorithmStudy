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

			divisor(N);
			sb.append("#").append(tc).append(" ").append(a).append(" ").append(b).append(" ").append(c).append(" ")
					.append(d).append(" ").append(e).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void divisor(int n) {
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (i == 2)
					a++;
				else if (i == 3)
					b++;
				else if (i == 5)
					c++;
				else if (i == 7)
					d++;
				else if (i == 11)
					e++;
				else if(i * i == n)
					divisor(i);
				else {
					divisor(i);
					divisor(n / i);
				}
				return;
			}
		}

	}
}

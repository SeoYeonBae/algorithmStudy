package baekjoon.class2;

import java.io.*;
import java.util.*;

public class Main_15829_Hashing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int L = Integer.parseInt(br.readLine());
		// a = 97
		
		String s = br.readLine();
		long r = 1;
		long res = 0;
		for (int i = 0; i < L; i++) {
			int c = s.charAt(i) - 96;
			res += c * r;
			r = (r * 31) % 1234567891;
		}
		
		System.out.println(res % 1234567891);
		br.close();
	}
}

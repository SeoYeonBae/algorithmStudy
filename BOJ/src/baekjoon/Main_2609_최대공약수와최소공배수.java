package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2609_최대공약수와최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcdNum, lcmNum;
		if (a > b)
			gcdNum = gcd(a, b);
		else
			gcdNum = gcd(b, a);

		lcmNum = a * b / gcdNum;
		
		sb.append(gcdNum).append("\n").append(lcmNum);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int gcd(int a, int b) {
		if (b == 0) 
			return a;
		return gcd(b, a % b);

	}

}

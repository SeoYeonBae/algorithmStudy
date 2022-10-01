package baekjoon.class4;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {

	static long c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		
		System.out.println(pow(a, b));
	}

	private static long pow(long a, long b) {
		if(b == 1)
			return a % c;
		
		long tmp = pow(a , b / 2);
		
		if(b % 2 == 0)
			return (tmp * tmp) %c;
		
		return ((tmp * tmp) % c) * a % c;
	}
}

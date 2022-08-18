// CLASS_2 2609 최대공약수와 최소공배수

package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int d = gcd(N, M);
		System.out.println(d);
		System.out.println(N * M / d);
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		return gcd(b, a % b);
	}
	
}

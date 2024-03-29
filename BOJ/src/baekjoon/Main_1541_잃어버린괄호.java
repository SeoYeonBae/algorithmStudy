package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer minus = new StringTokenizer(br.readLine(), "-");
		
		int res = Integer.MAX_VALUE;
		
		while(minus.hasMoreTokens()) {
			int sum = 0;
			StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");
			while(plus.hasMoreTokens())
				sum += Integer.parseInt(plus.nextToken());
			
			if(res == Integer.MAX_VALUE)
				res = sum;
			else
				res -= sum;
		}
		System.out.println(res);			
	}
}

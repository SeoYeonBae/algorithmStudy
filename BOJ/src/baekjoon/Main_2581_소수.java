package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2581_소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = -1;
		for (int i = M; i <= N; i++) {
			if(isPrime(i)) {
				if(min == -1)
					min = i;
				sum += i;
			}
		}
		
		if(min == -1)
			sb.append(-1);
		else
			sb.append(sum).append("\n").append(min);

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static boolean isPrime(int num) {
		if(num == 1)
			return false;
		
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}
}

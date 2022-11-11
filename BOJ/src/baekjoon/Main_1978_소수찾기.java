package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1978_소수찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int res = 0;
		for (int tc = 0; tc < T; tc++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == 1)
				continue;
			boolean isPrime = true;
			for (int i = 1; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					if(i != 1) {
						isPrime= false;
						break;
					}
				}
			}
			if(isPrime)
				res++;
		}
		System.out.println(res);
		br.close();

	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2023_신기한소수 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] init = {"2", "3", "5", "7"};
		
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		
		for(int i = 0; i < 4; i++) {
			makeNum(init[i]);
		}
	}

	private static void makeNum(String num) {
		String[] after = {"1", "3", "7", "9"};
		
		if(num.length() == N) {
			System.out.println(num);
			return;
		}
		for(int i = 0; i < 4; i++) {
			if(isPrime(Integer.parseInt(num + after[i]))) {
				makeNum(num + after[i]);
			}
		}
		
	}

	private static boolean isPrime(int num) {
		for (int i = 2; i < Math.sqrt(num) + 1; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}

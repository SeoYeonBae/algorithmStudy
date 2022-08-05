package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2023_신기한소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> init = new ArrayList<>();
		for (int i = 3; i < 10; i++)
			if (isPrime(i))
				init.add(i);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		for (int i = 2; i < 10; i++) {
			if (isPrime(i)) {
				String s = Integer.toString(i);
				for (int j = 0; j < N - 1; j++) {
					for (int k = 1; k < 9; k++)
						if (isPrime(Integer.parseInt(s + k))) {
							s = s + Integer.toString(k);
							if (s.length() == 4)
								System.out.println(s);
						}
				}
			}
		}

	}

	public static boolean isPrime(int num) {
		for (int i = 2; i < Math.sqrt(num) + 1; i++)
			if (num % i == 0)
				return false;
		return true;
	}
}

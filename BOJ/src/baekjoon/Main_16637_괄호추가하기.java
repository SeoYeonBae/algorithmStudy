package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16637_괄호추가하기 {

	static int max, N;
	static char[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		input = new char[N];
		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			input[i] = s.charAt(i);
		}

		max = Integer.MIN_VALUE;
		go(1, input[0] - '0');
		
		System.out.println(max);
	}
	
	// 괄호를 만들지 않은 경우와 만든 경우를 재귀로 탐색
	private static void go(int idx, int num) {
		if (idx >= N) {
			max = Math.max(max, num);
			return;
		}

		int tmp = input[idx + 1] - '0'; 	// 괄호 만들지 않고 계산
		go(idx + 2, calc(idx, num, tmp));
		
		// 괄호를 오른쪽에 만들고 계산
		// 왼쪽은 만들 필요 x 왜냐면 연산자 우선순위 없이 왼쪽부터 순차계산이기 때문
		if(idx + 3 < N) {	
			tmp = calc(idx + 2, input[idx + 1] - '0', input[idx + 3] - '0'); 	
			go(idx + 4, calc(idx, num, tmp));			
		}
	}

	private static int calc(int idx, int a, int b) {
		int res = 0;
		switch (input[idx]) {
		case '+':
			res = a + b;
			break;
		case '-':
			res = a - b;
			break;
		case '*':
			res = a * b;
			break;
		}
		return res;
	}

}

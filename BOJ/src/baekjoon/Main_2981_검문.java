package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class Main_2981_검문 {

	static int N;
	static Integer[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		nums = new Integer[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		// 두 수의 차가 음수가 되지 않기 위해 정렬
		Arrays.sort(nums, Collections.reverseOrder());
		
		Integer gcdNum = nums[0] - nums[1];
		for (int i = 1; i < N - 1; i++) {
			// 이미 구한 최대 공약수와 다음 수의 최대 공약수를 구해줌
			gcdNum = gcd(gcdNum, nums[i] - nums[i + 1]);
		}
		
		// 최대 공약수의 약수를 구함
		for (int i = 2; i <= gcdNum; i++) {
			if(gcdNum % i == 0)
				sb.append(i).append(" ");
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
	private static Integer gcd(Integer a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}

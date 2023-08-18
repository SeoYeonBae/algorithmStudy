package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253_좋다 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		int res = 0;
		
		// numbers[i]를 만들 수 있는지 확인
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;
			
			while(left < right) {
				if (left == i)
					left++;
				else if(right == i)
					right--;
				else {
					if(numbers[left] + numbers[right] < numbers[i])
						left++;
					else if(numbers[left] + numbers[right] > numbers[i])
						right--;
					else {
						res++;
						break;
					}
				}
			}
		}
		
		System.out.println(res);
	}
}

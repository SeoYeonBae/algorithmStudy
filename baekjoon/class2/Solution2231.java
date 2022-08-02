// CLASS_2 2231 분해합

package algorithmStudy.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			int number = i;
			int sum = 0;
			
			while(number != 0) {
				sum += number % 10;
				number = number / 10;
			}
			
			if(sum + i == N) {
				result = i;
				break;
			}	
		}
		
		System.out.println(result);
	}
}

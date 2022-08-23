package baekjoon.class2;

import java.io.*;
import java.util.*;

public class Main_10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		int input, res = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			input = Integer.parseInt(br.readLine());
			if(input == 0)
				stack.pop();
			else
				stack.add(input);
		}
		
		while(!stack.isEmpty()) {
			res += stack.pop();
		}
		
		System.out.println(res);
	}
}

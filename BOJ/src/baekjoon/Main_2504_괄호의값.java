package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2504_괄호의값 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int res = 0;
		int sum = 1;
		
		String input = br.readLine();
		int len = input.length();
		
		if(len % 2 == 1) {
			System.out.println(0);
			System.exit(0);
		}
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < len; i++) {
			char c = input.charAt(i);
			if(c == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					res = 0;
					break;
				}
				if(input.charAt(i - 1) == '(')
					res += sum;
				stack.pop();
				sum /= 2;
				
			}else if(c == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					res = 0;
					break;
				}
				if(input.charAt(i - 1) == '[')
					res += sum;
				stack.pop();
				sum /= 3;
			}else {
				if(c == '(')
					sum *= 2;
				else
					sum *= 3;
				stack.push(c);
			}
		}
		System.out.println(res);
		br.close();
	}
}

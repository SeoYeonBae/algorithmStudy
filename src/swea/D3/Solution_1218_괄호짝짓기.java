package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Solution_1218_괄호짝짓기 {
	
	public static void main(String[] args) throws IOException {
		
		int N;
		String input;
		Stack<Character> stack;
		
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(in.readLine());
			input = in.readLine();
			stack = new Stack<>();
			
			for (int i = 0; i < N; i++) {
				char c = input.charAt(i);
				if (c == ')' && stack.peek() == '(')
					stack.pop();
				else if (c == ']' && stack.peek() == '[')
					stack.pop();
				else if (c == '}' && stack.peek() == '{')
					stack.pop();
				else if (c == '>' && stack.peek() == '<')
					stack.pop();
				else
					stack.push(c);
			}
			
			if (stack.isEmpty())
				sb.append("1").append("\n");
			else
				sb.append("0").append("\n");
		}
		
		System.out.println(sb);
		
	}


}
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_오큰수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int A = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[A];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] ans = new int[A];
		Stack<Integer> stack = new Stack<>();
		for (int i = A - 1; i >= 0; i--) {
			
			while(!stack.isEmpty() && stack.peek() <= numbers[i])
				stack.pop();
			
			if(stack.isEmpty())
				ans[i] = -1;
			else
				ans[i] = stack.peek();
			
			stack.push(numbers[i]);
		}
		
		for (int i = 0; i < A; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
}

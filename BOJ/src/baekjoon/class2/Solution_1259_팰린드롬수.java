package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		while(!s.equals("0")) {
			if(s.length() % 2 == 0) {
				for(int i = 0; i < s.length() / 2; i++)
					sb1.append(s.charAt(i));
				for(int i = s.length() - 1; i >= s.length() / 2; i--)
					sb2.append(s.charAt(i));
				if(sb1.toString().equals(sb2.toString()))
					System.out.println("yes");
				else
					System.out.println("no");
			}else {
				for(int i = 0; i <= s.length() / 2; i++)
					sb1.append(s.charAt(i));
				for(int i = s.length() - 1; i >= s.length() / 2; i--)
					sb2.append(s.charAt(i));
				if(sb1.toString().equals(sb2.toString()))
					System.out.println("yes");
				else
					System.out.println("no");
			}
			s = in.readLine();
			sb1.setLength(0);
			sb2.setLength(0);
		}
	}
	
}

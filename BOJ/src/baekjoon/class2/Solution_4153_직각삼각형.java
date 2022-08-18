package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4153_직각삼각형 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		while(x != 0 && y != 0 && z != 0) {
			if(Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2))
				System.out.println("right");
			else if(Math.pow(y, 2) + Math.pow(z, 2) == Math.pow(x, 2))
				System.out.println("right");
			else if(Math.pow(x, 2) + Math.pow(z, 2) == Math.pow(y, 2))
				System.out.println("right");
			else
				System.out.println("wrong");
			st = new StringTokenizer(in.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
		}
	}
	
}

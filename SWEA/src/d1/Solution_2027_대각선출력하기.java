package d1;

import java.io.*;
import java.util.*;

public class Solution_2027_대각선출력하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(i == j)
					sb.append("#");
				else
					sb.append("+");
			}
			sb.append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

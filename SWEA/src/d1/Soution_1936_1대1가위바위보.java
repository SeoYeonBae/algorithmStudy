package d1;

import java.io.*;
import java.util.*;

public class Soution_1936_1대1가위바위보 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		if(A == 1) {
			if(B == 2)
				System.out.println('B');
			else
				System.out.println('A');
		}else if(A == 2) {
			if(B == 1)
				System.out.println('A');
			else
				System.out.println('B');
		}else {
			if(B == 1)
				System.out.println('B');
			else
				System.out.println('A');
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_3568_iSharp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

//		System.out.println((int)'&'); 	// 38
//		System.out.println((int)'*');	// 42
//		System.out.println((int)'[');	// 91
//		System.out.println((int)']');	// 93
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String def = st.nextToken();
		while(st.hasMoreTokens()){
			sb.append(def);
			String input = st.nextToken();
			input = input.replaceAll("\\[]", "\\][");
			
			int index = input.length() - 2;
			while(input.charAt(index) == 38 || input.charAt(index) == 42 || input.charAt(index) == 91 || input.charAt(index) == 93) {
				sb.append(input.charAt(index));
				index--;
			}
			
			sb.append(" ");
			
			for (int i = 0; i <= index; i++) {
				sb.append(input.charAt(i));
			}
			sb.append(";").append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

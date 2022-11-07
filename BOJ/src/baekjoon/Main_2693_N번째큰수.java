package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2693_N번째큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			List<Integer> A = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(A, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
					
				}
			});
			sb.append(A.get(2)).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_10814_나이순정렬 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String[][] people = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			people[i][0] = st.nextToken();
			people[i][1] = st.nextToken();
		}
		
		Arrays.sort(people, new Comparator<String[]>() {
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); 
			}
		});
		
		for(int i = 0; i < N; i++)
			sb.append(people[i][0]).append(" ").append(people[i][1]).append("\n");
		
		System.out.println(sb);
	}
	
}

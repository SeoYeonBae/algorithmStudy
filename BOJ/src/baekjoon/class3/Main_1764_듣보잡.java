package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_1764_듣보잡 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> listen = new HashSet<>();
		for (int i = 0; i < N; i++) {
			listen.add(br.readLine());
		}
		
		String name;
		List<String> resList = new ArrayList<String>();
		for (int i = 0; i < M; i++) {
			name = br.readLine();
			if(listen.contains(name))
				resList.add(name);
		}
		
		Collections.sort(resList);
		sb.append(resList.size()).append("\n");
		for(String s : resList)
			sb.append(s).append("\n");
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

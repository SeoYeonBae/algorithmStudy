package baekjoon.class3;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터이다솜 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();
		
		String p;
		for (int i = 1; i <= N; i++) {
			p = br.readLine();
			map1.put(i, p);
			map2.put(p, i);
		}

		for (int i = 0; i < M; i++) {
			p = br.readLine();
			
			if(Character.isDigit(p.charAt(0)))
				sb.append(map1.get(Integer.parseInt(p))).append("\n");	
			else 	// 입력이 문자열이라면
				sb.append(map2.get(p)).append("\n");	
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}

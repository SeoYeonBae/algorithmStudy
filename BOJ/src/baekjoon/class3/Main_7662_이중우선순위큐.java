package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_7662_이중우선순위큐 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				char order = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if(order == 'I') {
					if(map.containsKey(num))
						map.put(num, map.get(num) + 1);
					else
						map.put(num, 1);
				}else {
					if(map.isEmpty())
						continue;
					else if(num == 1) {
						int max = map.lastKey();
						if(map.get(max) == 1)
							map.remove(max);
						else
							map.put(max, map.get(max) - 1);
					}else {
						int min = map.firstKey();
						if(map.get(min) == 1)
							map.remove(min);
						else
							map.put(min, map.get(min) - 1);
					}
				}
			}
			if(map.isEmpty())
				sb.append("EMPTY").append("\n");
			else
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

package d3;

import java.io.*;
import java.util.*;

public class Solution_1208_Flatten_re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {
			int dump = Integer.parseInt(br.readLine());
			
			List<Integer> box = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				box.add(Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0; i < dump; i++) {
				int max = Collections.max(box);
				int min = Collections.min(box);
				
				box.set(box.indexOf(max), box.get(box.indexOf(max)) - 1);
				box.set(box.indexOf(min), box.get(box.indexOf(min)) + 1);
			}
			int res = Collections.max(box) - Collections.min(box);
			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

package d3;

import java.io.*;
import java.util.*;

public class Solution_1229_암호문2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());

			List<Integer> list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				char dir = st.nextToken().charAt(0);
				if (dir == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					if (x + y >= list.size()) {
						int len = list.size();
						for (int k = 0; k < x + y - len; k++) {
							list.add(0);
						}
					}
					for (int j = 0; j < y; j++) {
						int num = Integer.parseInt(st.nextToken());
						list.add(x + j, num);
					}
				}else {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						if(list.size() < x)
							break;
						list.remove(x);
					}
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

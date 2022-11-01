package d3;

import java.io.*;
import java.util.*;

public class Solution_1215_회문1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int h = Integer.parseInt(br.readLine());
			char[][] map = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String s = br.readLine();
				for (int j = 0; j < 8; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			int ans = 0;
			if(h == 1) {
				ans = 64;
			}else {
				int r = 0;
				List<Character> list = new ArrayList<Character>();
				for (int i = 0; i < 8; i++) {
					
					for (int j = 0; j < h; j++) {
						list.add(map[r][j]);						
					}
					
					int cnt = 0;
					for (int j = 0; j < h / 2; j++) {
						if(list.get(j) == list.get(h - 1 - j))
							cnt++;
						else
							break;
					}
					
					if(cnt == h / 2) {
						ans++;
					}
					for (int j = h; j < 8; j++) {
						cnt = 0;
						list.remove(0);
						list.add(map[r][j]);
						
						for (int k = 0; k < h / 2; k++) {
							if(list.get(k) == list.get(h - 1 - k))
								cnt++;
							else 
								break;
						}
						
						if(cnt == h / 2) {
							ans++;
						}
					}
					list.clear();
					r++;
				}
				int c = 0;
				for (int i = 0; i < 8; i++) {
					
					for (int j = 0; j < h; j++) {
						list.add(map[j][c]);						
					}
					
					int cnt = 0;
					for (int j = 0; j < h / 2; j++) {
						if(list.get(j) == list.get(h - 1 - j))
							cnt++;
						else break;
					}
					
					if(cnt == h / 2) {
						ans++;
					}
					
					for (int j = h; j < 8; j++) {
						cnt = 0;
						list.remove(0);
						list.add(map[j][c]);
						
						for (int k = 0; k < h / 2; k++) {
							if(list.get(k) == list.get(h - 1 - k))
								cnt++;
							else
								break;
						}
						
						if(cnt == h / 2) {
							ans++;
						}
					}
					c++;
					list.clear();
				}
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

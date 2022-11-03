package d3;

import java.io.*;
import java.util.*;

public class Solution_1221_GNS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int len = Integer.parseInt(st.nextToken());

			int[] memo = new int[10];
			Arrays.fill(memo, 0);
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len; i++) {
				String input = st.nextToken();
				switch (input) {
				case "ZRO":
					memo[0]++;
					break;
				case "ONE":
					memo[1]++;
					break;
				case "TWO":
					memo[2]++;
					break;
				case "THR":
					memo[3]++;
					break;
				case "FOR":
					memo[4]++;
					break;
				case "FIV":
					memo[5]++;
					break;
				case "SIX":
					memo[6]++;
					break;
				case "SVN":
					memo[7]++;
					break;
				case "EGT":
					memo[8]++;
					break;
				case "NIN":
					memo[9]++;
					break;
				}
			}
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < 10; i++) {
				int cnt = memo[i];
				String res = "";
				switch (i) {
				case 0:
					res = "ZRO";
					break;
				case 1:
					res = "ONE";
					break;
				case 2:
					res = "TWO";
					break;
				case 3:
					res = "THR";
					break;
				case 4:
					res = "FOR";
					break;
				case 5:
					res = "FIV";
					break;
				case 6:
					res = "SIX";
					break;
				case 7:
					res = "SVN";
					break;
				case 8:
					res = "EGT";
					break;
				case 9:
					res = "NIN";
					break;
				}
				for (int j = 0; j < cnt; j++) {
					sb.append(res).append(" ");
				}
			}
			sb.append("\n");
//			Map<String, Integer> map = new HashMap<>();
//			map.put("ZRO", 0);
//			map.put("ONE", 0);
//			map.put("TWO", 0);
//			map.put("THR", 0);
//			map.put("FOR", 0);
//			map.put("FIV", 0);
//			map.put("SIX", 0);
//			map.put("SVN", 0);
//			map.put("EGT", 0);
//			map.put("NIN", 0);
//			st = new StringTokenizer(br.readLine());
//			for (int i = 0; i < len; i++) {
//				String input = st.nextToken();
//				map.replace(input, map.get(input) + 1);
//			}
//
//			sb.append("#").append(tc).append("\n");
//			for (int i = 0; i < map.get("ZRO"); i++)
//				sb.append("ZRO").append(" ");
//			for (int i = 0; i < map.get("ONE"); i++)
//				sb.append("ONE").append(" ");
//			for (int i = 0; i < map.get("TWO"); i++)
//				sb.append("TWO").append(" ");
//			for (int i = 0; i < map.get("THR"); i++)
//				sb.append("THR").append(" ");
//			for (int i = 0; i < map.get("FOR"); i++)
//				sb.append("FOR").append(" ");
//			for (int i = 0; i < map.get("FIV"); i++)
//				sb.append("FIV").append(" ");
//			for (int i = 0; i < map.get("SIX"); i++)
//				sb.append("SIX").append(" ");
//			for (int i = 0; i < map.get("SVN"); i++)
//				sb.append("SVN").append(" ");
//			for (int i = 0; i < map.get("EGT"); i++)
//				sb.append("EGT").append(" ");
//			for (int i = 0; i < map.get("NIN"); i++)
//				sb.append("NIN").append(" ");
//			sb.append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

package d1;

import java.io.*;

public class Solution_2056_연월일달력 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for (int tc = 1; tc <= T; tc++) {
			String input = br.readLine();
			char[] year = new char[4];
			input.getChars(0, 4, year, 0);
			
			char[] inputMonth = new char[2];
			input.getChars(4, 6, inputMonth, 0);
			int month = Integer.parseInt(String.valueOf(inputMonth));
			if(month < 0 || month > 12) {
				sb.append("#").append(tc).append(" -1\n");
				continue;
			}
			
			char[] inputDay = new char[2];
			input.getChars(6, 8, inputDay, 0);
			int day = Integer.parseInt(String.valueOf(inputDay));
			if(day < 0 || day > days[month]) {
				sb.append("#").append(tc).append(" -1\n");
				continue;
			}

			
			sb.append("#").append(tc).append(" ").append(year).append("/").append(inputMonth).append("/").append(inputDay).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}


import java.io.*;
import java.util.*;

public class Solution_2072_홀수만더하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				int num = Integer.parseInt(st.nextToken());
				if(num % 2 == 1)
					sum += num;
			}
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

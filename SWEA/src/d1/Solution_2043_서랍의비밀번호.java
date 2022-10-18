package d1;

import java.io.*;
import java.util.*;

public class Solution_2043_서랍의비밀번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int res = P - K + 1;
		
		System.out.println(res);
		br.close();
	}
}

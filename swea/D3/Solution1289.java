// D3 1289 원재의 메모리 복구하기

package algorithmStudy.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1289 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int cnt, len;
		for(int tc = 1; tc <= T; tc++) {
			String s = in.readLine();
			len = s.length();
			cnt = 0;
			for(int i = 0 ; i < len - 1; i++) {
				if(s.charAt(i) != s.charAt(i+1))
					cnt++;
			}
			if(s.charAt(0) == '1')
				cnt++;
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
}

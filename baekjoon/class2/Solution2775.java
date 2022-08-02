// LASS_2 2775 부녀회장이 될테야

package algorithmStudy.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2775 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(in.readLine()) + 1;
			int n = Integer.parseInt(in.readLine());
			
			int num = 1;
			int[][] apart = new int[k][n];
			
			for(int i = 0; i < n; i++)
				apart[0][i] = num++;
			
			for(int i = 0; i < k; i++)
				apart[i][0] = 1;
			
			for(int i = 1; i < k; i ++) {
				for(int j = 1; j < n; j++) {
					apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
				}
			}
			
			System.out.println(apart[k - 1][n - 1]);
		}
	}
}

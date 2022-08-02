// CLASS_2 7568 덩치

package baekjoon.class2;

import java.io.*;
import java.util.StringTokenizer;

public class Solution7568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[][] people = new int[N][2];
		int k = 0;
		String res = "";
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			people[i][0] = Integer.parseInt(st.nextToken());
			people[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			k = 1;
			for (int j = 0; j < N; j++) {
				if(i == j)
					continue;
				if (people[i][0] < people[j][0] && people[i][1] < people[j][1])
					k++;
			}
			res += k + " ";
		}
		System.out.println(res);
		
	}
}

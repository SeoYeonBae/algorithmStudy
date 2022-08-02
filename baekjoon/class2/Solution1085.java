// CLASS_2 1085 직사각형에서 탈출

package algorithmStudy.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

				String[] s = in.readLine().split(" ");
				int x = Integer.parseInt(s[0]);
				int y = Integer.parseInt(s[1]);
				int w = Integer.parseInt(s[2]);
				int h = Integer.parseInt(s[3]);

				int min1 = Math.min(w - x, h - y);
				int min2 = Math.min(x, y);
				int result = Math.min(min1, min2);

				System.out.println(result);

	}
}

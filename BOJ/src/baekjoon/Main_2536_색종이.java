package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2536_색종이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] paper = new int[100][100];
		
		int result = 0;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++){
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			for(int i = r; i < r + 10; i++) {
				for(int j = c; j < c + 10; j++) {
					if(paper[i][j] == 0) {
						paper[i][j] = 1;
						result++;
					}
				}
			}
		}
		System.out.println(result);
		
	}
}

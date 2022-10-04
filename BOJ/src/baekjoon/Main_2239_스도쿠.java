package baekjoon;

import java.io.*;

public class Main_2239_스도쿠 {

	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		String input;
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			input = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = Character.getNumericValue(input.charAt(j));
			}
		}
		
		sdoku(0, 0);
	}
	// 한줄씩 1-9까지 차례대로 채워봄
	private static void sdoku(int r, int c) {
		int nr = r;
		int nc = c + 1;
		// 마지막 열까지 탐색 다 했으면 다음 줄로 넘김
		if(nc == 9) {
			nr = r + 1;
			nc = 0;
		}
		
		// r = 9라면 마지막줄까지 탐색 마치고 그 다음줄을 간 거니까 종료
		if(r == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}	
		    System.out.println(sb);
			System.exit(0);
		}
		// 빈칸인 스도쿠일 때만 탐색
		if(map[r][c] != 0)
			sdoku(nr, nc);
		else {
			for (int i = 1; i <= 9; i++) {
				if(check(r, c, i)) continue;
				map[r][c] = i;
				sdoku(nr, nc);
				map[r][c] = 0;
			}			
		}
		
	}

	private static boolean check(int r, int c, int num) {
		// 가로 검사
		for (int i = 0; i < 9; i++) {
			if(map[r][i] == num)
				return true;
		}
		
		// 세로 검사
		for (int i = 0; i < 9; i++) {
			if(map[i][c] == num)
				return true;
		}
		
		// 작은 사각형 검사
		int R = r/3*3;
		int C = c/3*3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(map[R+i][C+j] == num)
					return true;				
			}
		}
		return false;
	}
}

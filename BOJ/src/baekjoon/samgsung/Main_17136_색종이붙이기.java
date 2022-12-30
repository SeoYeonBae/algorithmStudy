package baekjoon.samgsung;

import java.io.*;
import java.util.StringTokenizer;

public class Main_17136_색종이붙이기 {

	static int[][] map;
	static int[] paper = { 0, 5, 5, 5, 5, 5 }; // 1-5크기의 종이는 각 5개씩 존재
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;
		dfs(0, 0, 0);

		if (min == Integer.MAX_VALUE) // 최솟값 갱신이 되지 않았다면 -1 출력
			System.out.println(-1);
		else
			System.out.println(min);
	}

	// 한칸씩 전진하는 방식 만약 열의 범위를 넘어가면 다음 줄의 0번째 칸으로 넘겨줌
	private static void dfs(int r, int c, int cnt) {
		// 마지막에 도착하면 최솟값 갱신하고 종료
		// (9,9)에도 크기 1짜리 색종이를 둘 수 있어서 (9,10)에서 종료함
		if (r == 9 && c == 10) { 
			min = Math.min(min, cnt);
			return;
		}
		
		if (cnt >= min) // 최솟값보다 섹종이를 많이 썼다면 리턴
			return;
		
		if(c >= 10) {	//	열의 범위를 벗어나면 다음 줄로 갈 때가 된 것! 
			dfs(r + 1, 0, cnt);
			return;
		}
		
		if (map[r][c] == 1) { // 종이를 둬야 하는 칸이라면
			for (int i = 5; i > 0; i--) { // 1~5 크기의 색종이를 둬본다
				if(r + i > 10 || c + i > 10)	// 칸에 색종이가 범위를 벗어나면 무시
					continue;
				
				if(paper[i] == 0)	// 해당 크기의 가진 색종이를 다 쓴 경우
					continue;
				
				if (possible(r, c, i)) { // 색종이를 둘 수 있는 칸이라면
					put(r, c, i); // 색종이를 두고
					paper[i]--; // 색종이 썼으니까 수 감소
					dfs(r, c + 1, cnt + 1);
					remove(r, c, i); // 색종이 복구
					paper[i]++;
				}
			}
		}else	// 색종이를 둘 칸이 아니라면
			dfs(r, c + 1, cnt);
	}

	private static void remove(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				map[i][j] = 1;
			}
		}

	}

	private static void put(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				map[i][j] = 0;
			}
		}
	}

	private static boolean possible(int r, int c, int k) {
		for (int i = r; i < r + k; i++) {
			for (int j = c; j < c + k; j++) {
				if (map[i][j] == 0) // 0이 있는 칸에는 색종이를 둘 수 없음 따라서 return false
					return false;
			}
		}
		return true;
	}
}

package baekjoon.samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_21608_상어초등학교 {

	static int N, res;
	static int[] order;
	static int[][] seat, students;
	static List<int[]> likeList, emptyList;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		order = new int[N * N + 1];	// 학생 순서
		students = new int[N * N + 1][4];	// 좋아하는 학생 저장하는 배열
		for (int i = 1; i <= N * N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			order[i] = num;
			for (int j = 0; j < 4; j++) {
				students[num][j] = Integer.parseInt(st.nextToken());
			}
		}

		seat = new int[N + 1][N + 1];	// 학생 자리
		for (int i = 1; i <= N * N; i++) {
			// 1번 규칙
			likeList = new ArrayList<int[]>();
			like(order[i]);
			if (likeList.size() == 0) {	// 1을 만족하는 게 하나라면 바로 자리 지정
				seat[likeList.get(0)[0]][likeList.get(0)[1]] = order[i];
				continue;
			}
			// 2번 규칙
			emptyList = new ArrayList<int[]>();
			empty();
			if (emptyList.size() != 0) {	
				// 2번을 만족하는 게 여러개라면 3번 규칙 적용
				emptyList.sort(new Comparator<int[]>() {
					@Override
					public int compare(int[] o1, int[] o2) {
						if (o1[0] != o1[0])
							return o1[0] - o1[0];
						else
							return o1[1] - o1[1];
					}
				});
			}
			seat[emptyList.get(0)[0]][emptyList.get(0)[1]] = order[i];
		}
		// 학생 자리 배치 끝난 후 점수 계산
		res = 0;
		score();
		System.out.println(res);
	}

	// 점수 계산
	private static void score() {
		int cnt = 0;	// 인접한 곳에 좋아하는 학생이 몇 명인지 담는 변수
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt = 0;	
				int num = seat[i][j];
				List<Integer> list = new ArrayList<>();	// 좋아하는 학생의 list
				for (int k : students[num]) {
					list.add(k);
				}
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if (nr < 1 || nr > N || nc < 1 || nc > N)
						continue;
					
					if(list.contains(seat[nr][nc]))	// 인접한 칸의 값이 좋아하는 학생이면 cnt++
						cnt++;
				}
				
				switch (cnt) {
				case 1:
					res += 1;
					break;
				case 2:
					res += 10;
					break;
				case 3:
					res += 100;
					break;
				case 4:
					res += 1000;
					break;
				}
			}
		}
	}

	// 2번 규칙: 1번 칸들 중 비어있는 칸이 가장 많은 칸을 세어봄
	private static void empty() {
		int max = 0;
		int cnt = 0;
		for (int[] a : likeList) {
			cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nr = a[0] + dr[d];
				int nc = a[1] + dc[d];

				if (nr < 1 || nr > N || nc < 1 || nc > N)
					continue;

				if (seat[nr][nc] == 0)
					cnt++;
			}
			if (max < cnt) {
				emptyList.clear();
				emptyList.add(new int[] { a[0], a[1] });
				max = cnt;
			} else if (max == cnt)
				emptyList.add(new int[] { a[0], a[1] });
		}
	}
	
	// 1번 규칙: 비어있는 칸 중 좋아하는 학생이 가장 많은 칸 세어봄
	private static void like(int num) {
		int max = 0;
		List<Integer> list = new ArrayList<>();	// 좋아하는 학생의 list
		for (int k : students[num]) {
			list.add(k);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (seat[i][j] != 0) // 비어있는 칸이 아니면 패스
					continue;
				
				int cnt = 0; // 좋아하는 학생이 몇 명 인접한지 세어봄
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];

					if (nr < 1 || nr > N || nc < 1 || nc > N)
						continue;

					if (seat[nr][nc] == 0)
						continue;

					if(list.contains(seat[nr][nc]))	// 인접한 칸의 값이 좋아하는 학생이면 cnt++
						cnt++;
				}
				if (max < cnt) {
					likeList.clear();
					likeList.add(new int[] { i, j });
					max = cnt;
				} else if (max == cnt)
					likeList.add(new int[] { i, j });
			}
		}
	}
}
package baekjoon;

import java.io.*;
import java.util.*;

public class Main_17135_캐슬디펜스 {
	
	static ArrayList<int[]> enemy;
	static ArrayList<int[]> origin;
	static int N, M, D, max, kill;
	static int numbers[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];	// N + 1행에는 성이 있고 궁수를 둘 수 있음
		numbers = new int[3];				// 궁수 위치 조합 만들기 위한 배열
		enemy = new ArrayList<int[]>();		// 적의 위치를 담을 배열
		origin = new ArrayList<int[]>();
		
		int num;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					enemy.add(new int[] {i, j});
					origin.add(new int[] {i, j});
				}
				map[i][j] = num;
			}
		}
		
		Collections.sort(enemy, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		Collections.sort(origin, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		comb(0, 0);	
		System.out.println(max);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	private static void comb(int start, int cnt) {
		if(cnt == 3) {
//			System.out.println(Arrays.toString(numbers));
			int res = game();
			if(max < res)
				max = res;
			kill = 0;
			for(int[] o : origin) {
				enemy.add(new int[] {o[0], o[1]});
			}
			return;
		}
		
		for(int i = start; i < M; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}
		
	}
	private static int game() {
//		System.out.println("-------------------------------");
		while(enemy.size() != 0) {
			for(int i = 0; i < 3; i++) {
				int distMin = Integer.MAX_VALUE;
				int minIdx = -1;
				for(int j = 0; j < enemy.size(); j++) {
					int dist = Math.abs(N - enemy.get(j)[0]) + Math.abs(numbers[i] - enemy.get(j)[1]);
					if(dist <= D && dist < distMin) {
//						System.out.println(N + "-" + numbers[i]);
//						System.out.println(enemy.get(j)[0] + "-" + enemy.get(j)[1] + " 차이는? " + D);
						minIdx = j;
						distMin = dist;
					}
				}
				if(minIdx != -1) {
//					System.out.println("제거" + enemy.get(minIdx)[0] + "-" + enemy.get(minIdx)[1]);
					kill++;
					enemy.remove(minIdx);						
				}
			}
			int len = enemy.size();
			for(int i = len - 1; i >= 0; i--) {
//				System.out.println("남은 친구는? " + enemy.get(i)[0] + " - " + enemy.get(i)[1]);
				enemy.get(i)[0] += 1;
				if(enemy.get(i)[0] >= N) {
//					System.out.println("성 침입!!");
					enemy.remove(i);
				}
			}
		}
//		System.out.println(kill);
		return kill;
	}
	
	
	
	
}

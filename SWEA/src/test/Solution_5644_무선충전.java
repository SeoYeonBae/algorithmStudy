package test;

import java.io.*;
import java.util.*;

public class Solution_5644_무선충전 {
	static int M, bcCnt; // 총 이동시간과 BC의 개수
	static int[][] battery; // 배터리 정보
	static int Ar, Ac, Br, Bc;
	static int[] dr = { 0, -1, 0, 1, 0 }; // 이동하지 않음, 상, 우, 하, 좌
	static int[] dc = { 0, 0, 1, 0, -1 };
	static int res; // 충전값
	static int[] dirA, dirB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			Ar = 1; // 좌표 초기화
			Ac = 1;
			Br = 10;
			Bc = 10;
			res = 0; // 충전값 초기화

			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); // 총 이동시간
			bcCnt = Integer.parseInt(st.nextToken()); // BC 개수

			dirA = new int[M + 1]; // A와 B 이동 정보 입력 받을 배열
			dirB = new int[M + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++)
				dirA[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++)
				dirB[i] = Integer.parseInt(st.nextToken());

			battery = new int[bcCnt][4];
			for (int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				battery[i][0] = Integer.parseInt(st.nextToken());
				battery[i][1] = Integer.parseInt(st.nextToken());
				battery[i][2] = Integer.parseInt(st.nextToken());
				battery[i][3] = Integer.parseInt(st.nextToken());
			}

			move(0);

			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void move(int cnt) {
		int dA, dB, max; // A순서, B순서, 저장할 충전량 맥스값
		List<Integer> bcA, bcB;
		while (cnt < M + 1) {
			dA = dirA[cnt];
			dB = dirB[cnt];
			Ar += dr[dA];
			Ac += dc[dA];
			Br += dr[dB];
			Bc += dc[dB];

			bcA = new ArrayList<>();
			bcB = new ArrayList<>();

			for (int i = 0; i < bcCnt; i++) { // 배터리와 A B 거리 확인
				if (Math.abs(Ar - battery[i][1]) + Math.abs(Ac - battery[i][0]) <= battery[i][2])
					bcA.add(i);
				if (Math.abs(Br - battery[i][1]) + Math.abs(Bc - battery[i][0]) <= battery[i][2])
					bcB.add(i);
			}
			
			if (bcA.size() == 0 && bcB.size() == 0) { // 접속 가능한 충전기가 없을 땐 무시
				cnt++;
				continue;
			} else if (bcA.size() == 0) { // B만 접속 가능할 때
				max = 0;
				for (int b : bcB) {
					if (battery[b][3] > max)
						max = battery[b][3];
				}
				res += max;
			} else if (bcB.size() == 0) { // A만 접속 가능할 때
				max = 0;
				for (int a : bcA) {
					if (battery[a][3] > max)
						max = battery[a][3];
				}
				res += max;
			} else { // 둘 다 접속 가능할 때
				max = 0;
				for (int a : bcA) {
					for (int b : bcB) {
						int sum;
						if (a == b) {	// 둘이 하나를 공유할 때
							sum = battery[a][3]; 	// 어차피 하나를 반씩 가지니까 안 나누고 더하기
							if(sum > max)
								max = sum;
						} else {	// 둘 중 하나가 양보할 때
							sum = battery[a][3] + battery[b][3];	// 최종적으로는 더할 거니까 더해서 max 갱신하기
							if (sum > max) {
								max = sum;
							}
						}
					}
				}
				res += max;
			}

			cnt += 1;
		}
	}
}

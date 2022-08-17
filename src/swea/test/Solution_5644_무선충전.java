package swea.test;

import java.io.*;
import java.util.StringTokenizer;

public class Solution_5644_무선충전 {
	static int M, bcCnt; // 총 이동시간과 BC의 개수
	static int[][] battery;	// 배터리 정보
	static int Ar, Ac, Br, Bc;
	static int[] dr = {0, -1, 0, 1, 0}; // 이동하지 않음, 상, 우, 하, 좌
	static int[] dc = {0, 0, 1, 0, -1};
	static int chargeA, chargeB;	// 충전값
	static int[] dirA, dirB;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			Ar = 1;		// 좌표 초기화
			Ac = 1;
			Br = 10;
			Bc = 10;
			chargeA = 0;	// 충전값 초기화
			chargeB = 0;

			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());	// 총 이동시간
			bcCnt = Integer.parseInt(st.nextToken());	// BC 개수
			
			dirA = new int[M];	// A와 B 이동 정보 입력 받을 배열
			dirB = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 2; i++)
				dirA[i] = Integer.parseInt(st.nextToken());
			for(int i = 0; i < 2; i++)
				dirB[i] = Integer.parseInt(st.nextToken());
			
			battery = new int[bcCnt][4];
			for(int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				battery[i][0] = Integer.parseInt(st.nextToken());
				battery[i][1] = Integer.parseInt(st.nextToken());
				battery[i][2] = Integer.parseInt(st.nextToken());
				battery[i][3] = Integer.parseInt(st.nextToken());
			}
			
			move(0);
			
			sb.append("#").append(chargeA + chargeB).append("\n");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void move(int cnt) {
		if(cnt == M)	// 다 돌았으면 return
			return;
		
		for(int i = 0; i < bcCnt; i++) {	// 배터리 루프 돌면서 거리 확인
			if(Math.abs(Ar - battery[i][0]) + Math.abs(Ac - battery[i]))
		}
		int dA = dirA[cnt];
		int dB = dirB[cnt];
		
	}

	
}

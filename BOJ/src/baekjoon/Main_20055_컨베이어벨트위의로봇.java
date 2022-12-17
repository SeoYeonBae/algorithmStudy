package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20055_컨베이어벨트위의로봇 {

	static int N, K, down;
	static int[] belt;
	static List<Integer> robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		down = N - 1;	// 내려가는 칸 index
		N *= 2;	// 벨트의 총 길이

		st = new StringTokenizer(br.readLine());
		belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}

		// 벨트 위에 로봇이 있는지 없는지 저장
		robot = new ArrayList<Integer>();

		int turn = 0;
		do {
			turn++;
			
			rotate();	// 벨트와 로봇 돌림
			move();		// 로봇 움직임
			
			// 로봇 올림
			if(robot.indexOf(0) == -1 && belt[0] > 0) {
				belt[0]--;
				robot.add(0);
			}

		} while (count0());
		
		System.out.println(turn);
	}

	// 벨트 로봇 이동
	private static void move() {
		for(int i = 0; i < robot.size(); i++) {
			int idx = robot.get(i) + 1;
			if(idx == N - 1)
				idx = 0;
			// 이동하려는 칸에 로봇이 없고 내구도가 0 이상이면 로봇 이동
			if(robot.indexOf(idx) == -1 && belt[idx] > 0) {	
				// 다만 로봇이 가려는 칸이 내리는 칸이면 로봇 내림
				if(idx == down) {
					belt[idx]--;
					robot.remove(robot.indexOf(idx - 1));
					i--;
				}else {
					belt[idx]--;
					robot.set(i, idx);
				}
			}
		}
		
	}

	// 벨트와 로봇을 회전하는 함수
	private static void rotate() {
		// 벨트 회전
		int tmp = belt[N - 1];
		for (int i = N - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = tmp;

		// 로봇 회전
		for(int i = 0; i < robot.size(); i++) {
			int idx = robot.get(i) + 1;
			if(idx == N - 1)
				idx = 0;
				// 로봇이 가려는 칸이 내리는 칸이면 로봇 내림
				if(idx == down) {
					robot.remove(robot.indexOf(idx - 1));
					i--;
				}else {
					robot.set(i, idx);
				}
		}
	}

	// 내구도가 0인 칸의 수를 세는 함수
	private static boolean count0() {
		int cnt = 0;

		for (int i : belt) {
			if (i <= 0)
				cnt++;
		}

		if (cnt < K)
			return true;
		else
			return false;
	}

}

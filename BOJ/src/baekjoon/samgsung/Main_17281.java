package baekjoon.samgsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17281 {

	static int N, max, sum, player;
	static int[] nums, order, base;
	static int[][] players;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 이닝 수
		
		players = new int[N][9]; // 이닝 별 각 선수의 득점
		nums = new int[8];
		order = new int[9];	// 타순
		
		for (int i = 1; i < 9; i++) {	// 넥퍼로 순열 만들기 위한 초기화
			nums[i - 1] = i;
		}
		
		// 이닝별 타자의 득점
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				players[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최다 득점
		max = Integer.MIN_VALUE;
		
		do {
			// 감독이 좋아하는 선수를 포함한 타순 만들기
			for (int i = 0; i < 3; i++) {
				order[i] = nums[i];
			}
			order[3] = 0;
			for (int i = 3; i < 8; i++) {
				order[i + 1] = nums[i];
			}
			// 게임 시작
			go();
		} while (np());
		
		System.out.println(max);
	}
	private static void go() {
		sum = 0; // 총 득점
		int outCnt = 0;	// 3아웃이면 이닝 종료
		int cur = 0;	// 타석에 서야하는 타자
		base = new int[4];	// 루에 진출한 선수 명단
		Arrays.fill(base, 0);
		for (int t = 0; t < N; t++) {	// 이닝 수만큼 반복
			while(outCnt < 3) {	// 쓰리아웃이 나올 때까지 게임 진행
				player = order[cur];
				switch (players[t][player]) {
				case 0:
					outCnt++;
					break;
				case 1:
					run(1);
					break;
				case 2:
					run(2);
					break;
				case 3:
					run(3);
					break;
				case 4:
					run(4);
					break;
				}
				if(++cur == 9)	// 9번 타자까지 공을 쳤는데 쓰리아웃이 발생하지 않은 상황
					cur = 0;	// 0번 타자로 넘기고 경기 진행
			}
			
			// 쓰리아웃이면 필드, 아웃 카운트 초기화하고 다음 이닝으로 넘김 
			Arrays.fill(base, 0);
			outCnt = 0;
		}
		
		max = Math.max(max, sum);
	}
	
	// 현재 타자가 공을 쳐서 나가 있는 주자 달림
	private static int run(int ord) {
		for (int i = 3; i >= 0; i--) {
			if(base[i] != 0) {
				if(i + ord > 3) {
					base[i] = 0;
					sum += 1;
				}
				else {
					base[i + ord] = 1;
					base[i] = 0;
				}
			}
		}
		if(ord < 4)
			base[ord] = 1;
		else
			sum += 1;
		
		return sum;
	}
	
	private static boolean np() {
		int i = 7;
		while(i > 0 && nums[i - 1] >= nums[i]) --i;
		if(i == 0) return false;
		
		int j = 7;
		while(nums[i - 1] >= nums[j]) --j;
		swap(i - 1, j);
		
		int k = 7;
		while(i < k) swap(i++, k--);
		
		return true;
	}
	private static void swap(int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

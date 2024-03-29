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
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		numbers = new int[3]; // 궁수 위치 조합 만들기 위한 배열
		enemy = new ArrayList<int[]>(); // 적의 위치를 담을 배열
		origin = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					enemy.add(new int[] { i, j });
					origin.add(new int[] { i, j });
				}
			}
		}

		comb(0, 0);
		System.out.println(max);
		br.close();
	}

	private static void comb(int start, int cnt) {
		if (cnt == 3) {
			int res = game();
			if (max < res)
				max = res;
			kill = 0;
			for (int[] o : origin) {
				enemy.add(new int[] { o[0], o[1] });
			}
			return;
		}


		for (int i = start; i < M; i++) {
			numbers[cnt] = i;
			comb(i + 1, cnt + 1);
		}

	}

	private static int game() {
		
		while (enemy.size() != 0) {
			Set<Integer> attack = new HashSet<Integer>();	// 궁수가 같은 적을 공격하고자 할 때 중복해서 공격하는 일이 없도록 하기 위한 hash set
			int distMin, minIdx, removeIdx;
			for (int i = 0; i < 3; i++) {
				distMin = Integer.MAX_VALUE;	// 궁수와 적의 거리를 계산해 기준값 이하 중 최솟값을 저장할 변수
				minIdx = Integer.MAX_VALUE;		// 거리가 같은 적들 중 가장 왼쪽 값을 쓰기 위한 변수
				removeIdx = -100;				// 공격할 적의 리스트 인덱스 번호 만약 공격할 수 있는 적이 없다면 removeIdx는 계속 -100
				for (int j = 0; j < enemy.size(); j++) {
					int dist = Math.abs(N - enemy.get(j)[0]) + Math.abs(numbers[i] - enemy.get(j)[1]);
					if (dist <= D) {				// 거리가 기준값 이하일 때
						if (dist == distMin && enemy.get(j)[1] < minIdx) {	 	// 기존에 저장해둔 최소 거리와 같다면 제일 왼쪽적을 표적으로 함
							minIdx = enemy.get(j)[1];
							removeIdx = j;
						} else if (dist < distMin) {	// 기존에 저장해뒀던 거리보다 작다면 무조건 바꿔줌 = 가장 가까운 적 죽이기 위한 조건문
							minIdx = enemy.get(j)[1];
							removeIdx = j;
							distMin = dist;
						}
					}

				}
				if(removeIdx != -100)	// 공격할 수 있는 적이 있다면
					attack.add(removeIdx);
			}

			ArrayList<Integer> sortIdx = new ArrayList<>(attack);	// hashSet에 저장되어 있는 삭제해야 할 적의 인덱스 번호를 역순으로 정렬하기 위한 리스트
			Collections.sort(sortIdx, Collections.reverseOrder());	// 역순으로 정렬하는 이유는 리스트에서 0번부터 remove하면 뒤에 있는 원소들의 인덱스 값이 달라져 원하지 않는 걸 지움
			attack.clear();

			for(int i = 0; i < sortIdx.size(); i++) {	// 적 죽이기
				int num = sortIdx.get(i);
				kill++;
				enemy.remove(num);
			}

			int len = enemy.size();
			for (int i = len - 1; i >= 0; i--) {	// 맵에 남아있는 애들을 하나씩 밑으로 밀기
				enemy.get(i)[0] += 1;
				if (enemy.get(i)[0] >= N) {		// 만약 적이 성에 닿았다면 적을 지워줌
					enemy.remove(i);
				}
			}
		}
		return kill;	// 현재 game에서 죽인 적의 수 반환
	}

}

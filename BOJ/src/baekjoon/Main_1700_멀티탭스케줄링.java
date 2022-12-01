package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1700_멀티탭스케줄링 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer> multitap = new ArrayList<>();
		List<Integer> schedule = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			schedule.add(Integer.parseInt(st.nextToken()));
		}
		int idx = 0;
		int res = 0;
		while(idx < K) {
			// 멀티탭에 공간이 남아있고 아직 꽂지 않은 기기라면
			if(multitap.size() < N && !multitap.contains(schedule.get(idx))) {
				multitap.add(schedule.get(idx));
				idx++;
			}
			// 지금 꽂으려는 기기가 이미 멀티탭에 있다면 무시
			else if(multitap.contains(schedule.get(idx))) {
				idx++;
			}
			// 지금 꽂으려는 기기가 멀티탭에 없다면
			else {
				// 가장 나중에 쓰일 기기 혹은 나중에 아예 안 쓰이는 기기 찾음
				int last = -1;	// 가장 나중에 쓰일 기기의 번호
				int[] visit = new int[N];	// 플러그에 있는 기기가 뒤에 또 나오는지 확인
				Arrays.fill(visit, 0);
				for (int i = idx; i < K; i++) {
					for (int j = 0; j < N; j++) {
						if(multitap.get(j) == schedule.get(i) && visit[j] == 0) {	// 플러그에 있는 기기가 재사용됨을 확인
							visit[j]++;
							last = j;
							break;
						}
					}
				}
				for (int i = 0; i < N; i++) {
					if(visit[i] == 0)
						last = i;
				}
				multitap.remove(last);
				multitap.add(schedule.get(idx));
				idx++;
				res++;
			}
		}
		sb.append(res);
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

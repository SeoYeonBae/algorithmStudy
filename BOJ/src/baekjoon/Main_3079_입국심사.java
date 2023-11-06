package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3079_입국심사 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		long[] times = new long[(int)N];
		long maxTime = 0;
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(br.readLine());
			maxTime = Math.max(maxTime, times[i]);
		}

        // 시간을 기준으로 이분탐색
		long left = 1;
		long right = maxTime * M; // 가장 오래 걸리는 시간은 가장 느린 심사대에서 M명 모두가 받는 것 
		while(left <= right) {
			long mid = (left + right) / 2;
			long cnt = 0;
			for(long t : times){
				cnt += mid / t;	// mid초일 때 각 심사대에서 심사할 수 있는 사람의 최대수
				if(cnt >= M)
					break;
			}
			// M명 이상을 mid초 내에 통과할 수 있다면 시간 줄여봄
			if(cnt >= M) {
				right = mid - 1;
			}
			
			else {
				left = mid + 1;
			}
		}
		
		System.out.println(left);
	}
}

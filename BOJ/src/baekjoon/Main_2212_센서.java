package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2212_센서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());		
		int res = 0;
		int[] sensor = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);	// 센서 좌표 오름차순 정렬
		
		Integer[] distance = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			distance[i] = sensor[i + 1] - sensor[i];
		}
		Arrays.sort(distance, Collections.reverseOrder());	// 센서간의 거리 내림차순 정렬
		
		for (int i = K - 1; i < N - 1; i++) {
			res += distance[i];	// 가장 먼 K - 1개의 거리를 제외한 나머지 거리 더해줌
		}
		
		System.out.println(res);
	}
}

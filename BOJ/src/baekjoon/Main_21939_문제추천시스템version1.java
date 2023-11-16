package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_21939_문제추천시스템version1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> ascPq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])	// 난이도가 같다면
					return o2[0] - o1[0];	// 문제 번호 내림차순
				else
					return o2[1] - o1[1];	// 난이도가 다르면 난이도 내림차순 정렬
			}
		});
		PriorityQueue<int[]> descPq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])	// 난이도가 같다면
					return o1[0] - o2[0];	// 문제 번호 오름차순
				else
					return o1[1] - o2[1];	// 난이도가 다르면 난이도 오름차순 정렬
			}
		});
		int[] levels = new int[100001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			ascPq.add(new int[] {p, l});
			descPq.add(new int[] {p, l});
			levels[p] = l;
		}
		
		int M = Integer.parseInt(br.readLine());
		int p, l, x;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			switch (order) {
			case "recommend":
				x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					int[] cur = ascPq.peek();
					while(cur[1] != levels[cur[0]]) {
						ascPq.poll();
						cur = ascPq.peek();
					}
					sb.append(ascPq.peek()[0]).append("\n");
				}else {
					int[] cur = descPq.peek();
					while(cur[1] != levels[cur[0]]) {
						descPq.poll();
						cur = descPq.peek();
					}
					sb.append(descPq.peek()[0]).append("\n");
				}
				break;
			case "add":
				p = Integer.parseInt(st.nextToken());
				l = Integer.parseInt(st.nextToken());
				ascPq.add(new int[] {p, l});
				descPq.add(new int[] {p, l});
				levels[p] = l;
				break;
			case "solved":
				p = Integer.parseInt(st.nextToken());
				levels[p] = -1;
				break;
			}
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}

}

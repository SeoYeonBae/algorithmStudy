package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1092_배 {

	static int N, M, minTime;
	static List<Integer> crane, box;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		crane = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(crane, Collections.reverseOrder());

		M = Integer.parseInt(br.readLine());
		box = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box, Collections.reverseOrder());
		
		if(box.get(0) > crane.get(0))
			minTime = -1;
		else
			minTime = move();

		System.out.println(minTime);
	}

	private static int move() {
		int res = 0;
		
		while(!box.isEmpty()) {
			res++;
			for (int i = 0; i < N; i++) {
				if(crane.get(i) < box.get(box.size() - 1))
					break;
				
				for (int j = 0; j < box.size(); j++) {
					if(crane.get(i) >= box.get(j)) {
						box.remove(j);
						break;
					}
				}
				
				if(box.size() == 0)
					break;
			}
		}
		
		return res;
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		List<Integer> customer = new ArrayList<Integer>();
		int max = 0;
		for (int i = 0; i < k; i++) {
			if (!customer.contains(sushi[i]))
				max++;
			customer.add(sushi[i]);
		}
		if (!customer.contains(c))
			max++;
		int cnt = max;
		for (int i = 0; i < N - 1; i++) {
			int rm = customer.get(0);
			customer.remove(0);
			if (!customer.contains(rm))
				cnt--;
			if (!customer.contains(sushi[(i + k) % N]))
				cnt++;
			customer.add(sushi[(i + k) % N]);

			if (!customer.contains(c))
				max = max < cnt + 1 ? cnt + 1 : max;
			else
				max = max < cnt ? cnt : max;
		}

		System.out.println(max);
	}
}

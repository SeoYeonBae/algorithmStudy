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

		int[] customer = new int[d + 1];
		Arrays.fill(customer, 0);
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (customer[sushi[i]] == 0)
				cnt++;
			customer[sushi[i]]++;
		}
		int max = cnt;
		for (int i = 1; i < N; i++) {
			if(max <= cnt) {
				if(customer[c] == 0)
					max = cnt + 1;
				else
					max = cnt;
			}
			customer[sushi[i-1]]--;
			if(customer[sushi[i-1]] == 0)
				cnt--;
			
			if(customer[sushi[(i + k - 1) % N]] == 0)
				cnt++;
			customer[sushi[(i + k - 1) % N]]++;
		}
		System.out.println(max);
	}
}

// 0801 문제풀이 1244 스위치 켜고 끄기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] sw = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			sw[i] = Integer.parseInt(st.nextToken());
		int studentNum = Integer.parseInt(in.readLine());
		for (int s = 0; s < studentNum; s++) {
			StringTokenizer st2 = new StringTokenizer(in.readLine(), " ");
			int gender = Integer.parseInt(st2.nextToken());
			int num = Integer.parseInt(st2.nextToken());
			if (gender == 1)
				boy(sw, N, num);
			else
				girl(sw, N, num - 1);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(sw[i] + " ");
			if((i + 1) % 20 == 0)
				System.out.println();
		}
	}

	private static void boy(int[] sw, int limit, int num) {
		for (int i = num - 1; i < limit; i += num)
			if (sw[i] == 0)
				sw[i] = 1;
			else
				sw[i] = 0;
	}

	private static void girl(int[] sw, int limit, int num) {
		int cnt = 0;
		for (int i = 1; i < limit; i++) {
			if (num - i < 0 || num + i >= limit)
				break;
			if (sw[num - i] != sw[num + i])
				break;
			cnt++;
		}
		for (int i = num - cnt; i <= num + cnt; i++)
			if (sw[i] == 0)
				sw[i] = 1;
			else
				sw[i] = 0;
	}

}

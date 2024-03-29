package d4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3234_준환이의양팔저울 {

	
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		int N, weights[];
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 무게추의 수
			weights = new int[N]; // 무게추들의 무게를 담을 배열
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++)
				weights[i] = Integer.parseInt(st.nextToken());
			Arrays.sort(weights);	
			do {
				subSet(weights, N, 0, 0, 0);
			} while (np(weights));
			sb.append("#").append(tc).append(" ").append(res).append("\n");
			res = 0;
		}
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void subSet(int[] numbers, int n, int idx, int l, int r) {

		if(l < r) return;
		
		if (idx == n) {
			res++;
			return;
		}

		subSet(numbers, n, idx + 1, l, r + numbers[idx]);

		subSet(numbers, n, idx + 1, l + numbers[idx], r);

	}

	private static boolean np(int[] numbers) {
		int len = numbers.length;

		int i = len - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;

		if (i == 0)
			return false;

		int j = len - 1;
		while (numbers[i - 1] >= numbers[j])
			j--;

		swap(numbers, i - 1, j);

		int k = len - 1;
		while (i < k)
			swap(numbers, i++, k--);

		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;

	}

}

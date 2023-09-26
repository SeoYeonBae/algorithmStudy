package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1744_수묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			System.out.println(Integer.parseInt(br.readLine()));
			return;
		}

		int[] numbers = new int[N];
		boolean[] isUsed = new boolean[N]; // 수 묶기에 사용했는지 여부
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(numbers);
		Arrays.fill(isUsed, false);

		// 가장 큰 수부터 묶기 시작함
		// 두 수를 곱했을 때가 더했을 때보다 커야 함
		int res = 0;
		int right = N - 1;
		int gop = numbers[right] * numbers[right - 1];
		int hap = numbers[right] + numbers[right - 1];
		while (gop > hap) {
			isUsed[right] = true;
			isUsed[right - 1] = true;

			res += gop;
			right = right - 2;
			
			// 남은 숫자가 2개 이상이어야 함
			// 다음 수 묶기를 진행할 숫자가 음수라면 가장 작은 수부터 수묶기 재시작
			if (right < 1 || numbers[right] < 0)
				break;

			gop = numbers[right] * numbers[right - 1];
			hap = numbers[right] + numbers[right - 1];
		}
		
		// 가장 작은 수부터 묶기 시작
		// 마찬가지로 두 수를 곱했을 때가 더했을 때보다 커야 함
		int left = 0;
		gop = numbers[left] * numbers[left + 1];
		hap = numbers[left] + numbers[left + 1];
		while (gop > hap && !isUsed[left + 1]) {
			isUsed[left] = true;
			isUsed[left + 1] = true;

			res += gop;
			left = left + 2;
			
			// 남은 숫자가 2개 이상이어야 함
			// 양수는 이미 앞에서 다 살펴봄
			if (left > N - 2 || numbers[left] > 0) {
				break;
			}

			gop = numbers[left] * numbers[left + 1];
			hap = numbers[left] + numbers[left + 1];
		}
		
		// 묶지 않은 숫자 더해줌
		for (int i = left; i <= right; i++) {
			res += numbers[i];
		}

		System.out.println(res);
	}
}

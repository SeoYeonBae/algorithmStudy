package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_19539_사과나무 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		// 총 트리의 합
		int sum = 0;
		// 각 트리를 2로 성장시킬 수 있는 횟수의 합
		int sum2 = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num;
			sum2 += (num / 2);
		}
		br.close();
		
		// 한번에 3씩 증가할 수 있으므로 나무 높이의 총합은 반드시 3의 배수여야 함
		if(sum % 3 != 0) {
			sb.append("NO");
		}else {
			// 나무가 완성되는 일수
			sum /= 3;
			// 2로 성장시킨 횟수 = 나무가 완성되는 일수과 동일함
			// 따라서 sum2가 전체 일수보다 크거나 같아야 함
			if(sum2 >= sum)
				sb.append("YES");
			else
				sb.append("NO");
		}
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}

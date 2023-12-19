package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20444_색종이와가위 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		br.close();
		
		long left = 0;
		long right = N / 2;
		boolean isPossible = false;
		while(left <= right) {
			long r = (left + right) / 2;
			long c = N - r;
			
			long piece = (r + 1) * (c + 1);
			if(piece == K) {
				isPossible = true;
				break;
			}else if(piece < K)
				left = r + 1;
			else if(piece > K)
				right = r - 1;
		}
		
		if(isPossible)
			sb.append("YES");
		else
			sb.append("NO");
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
}

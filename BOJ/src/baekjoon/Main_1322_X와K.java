package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1322_X와K {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		String binaryX = Long.toBinaryString(X);
		String binaryK = Long.toBinaryString(K);
		int idxX = binaryX.length() - 1;
		int idxK = binaryK.length() - 1;
		
		StringBuilder sb = new StringBuilder();
		while(idxX >= 0) {
			char c = binaryX.charAt(idxX);
			if(c == '1') {
				sb.insert(0, 0);
			}else {
				if(idxK == -1)
					break;
				sb.insert(0, binaryK.charAt(idxK));
				idxK--;
			}
			idxX--;
		}
		while(idxK >= 0) {
			sb.insert(0, binaryK.charAt(idxK));
			idxK--;
		}
		
		System.out.println(Long.parseLong(sb.toString(), 2));
	}
}

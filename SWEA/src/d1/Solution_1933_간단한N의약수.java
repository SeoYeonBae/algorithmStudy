package d1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_1933_간단한N의약수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		List<Integer> acd = new ArrayList<Integer>();
		for (int i = 1; i <= Math.sqrt(N); i++) {
			if(N % i == 0) {
				if(Math.pow(i, 2) == N)
					acd.add(i);
				else {
					acd.add(i);
					acd.add(N/i);
				}
			}
		}
		Collections.sort(acd);
		for (int num : acd) {
			sb.append(num).append(" ");
		}
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

}

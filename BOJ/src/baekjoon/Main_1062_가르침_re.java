package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1062_가르침_re {

	static int N, K, res;
	static List<String> list;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// a, n, t, i, c는 무조건 알아야 함
		if(K < 5) {
			res = 0;
		}else if(K == 26) {	// 모든 알파벳 다 배움
			res = N;
		}else {
			list = new ArrayList<String>();
			
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				
				input = input.replaceAll("a", "");	// 무조건 다 배워야 되니까 일단 배웠다 생각하고 없앰
				input = input.replaceAll("n", "");
				input = input.replaceAll("t", "");
				input = input.replaceAll("i", "");
				input = input.replaceAll("c", "");
				
				list.add(input);
			}
			
			K -= 5;
			visit = new boolean[26];
			visit['a' - 'a'] = true;	// 배운 단어 표시
			visit['n' - 'a'] = true;
			visit['t' - 'a'] = true;
			visit['i' - 'a'] = true;
			visit['c' - 'a'] = true;
			res = Integer.MIN_VALUE;
			comb(0, 0);	// 꼭 배워야 하는 5개를 제외한 알파벳 조합 생성
		}
		System.out.println(res);
	}
	private static void comb(int start, int cnt) {
		if(cnt == K) {
			int wordCnt = 0;	// 지금까지 배운 알파벳으로 배울 수 있는 단어가 있는지 확인
			boolean possible = true;
			for (int i = 0; i < N; i++) {
				possible = true;
				String s = list.get(i);
				for (int j = 0; j < s.length(); j++) {
					if(!visit[s.charAt(j) - 'a']) {
						possible = false;
						break;
					}
				}
				if(possible)
					wordCnt++;
			}
			res = Math.max(res, wordCnt);
		}
		
		for (int i = start; i < 26; i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}
}

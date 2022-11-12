package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1062_가르침 {

	static int K, res;
	static List<Character> charList, combList;
	static List<String> wordList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) {
			System.out.println(0);
			System.exit(0);
		}

		res = Integer.MIN_VALUE;
		charList = new ArrayList<>();
		combList = new ArrayList<>();
		wordList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			word = word.replaceAll("a", "");
			word = word.replaceAll("n", "");
			word = word.replaceAll("t", "");
			word = word.replaceAll("i", "");
			word = word.replaceAll("c", "");

			wordList.add(word);
			for (int j = 0; j < word.length(); j++) {
				if(!charList.contains(word.charAt(j)))
					charList.add(word.charAt(j));
			}
		}
		
		if(K - 5 > charList.size())
			K = charList.size();
		else
			K -= 5;
		
		for (int i = 0; i < K; i++) {
			combList.add(' ');
		}
		
		comb(0, 0);		
		System.out.println(res);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void comb(int start, int cnt) {
		if(cnt == K) {
			check();
			return;
			
		}
		for (int i = start; i < charList.size(); i++) {
			combList.set(cnt, charList.get(i));
			comb(i + 1, cnt + 1);
		}
	}

	private static void check() {
		int cnt = 0;
		boolean isRead = true;
		for (int i = 0; i < wordList.size(); i++) {
			String s = wordList.get(i);
			isRead = true;
			for (int j = 0; j < s.length(); j++) {
				if(!combList.contains(s.charAt(j))) {
					isRead = false;
					break;
				}
			}
			if(isRead)
				cnt++;
		}
		res = Math.max(res, cnt);
		return;
	}
}

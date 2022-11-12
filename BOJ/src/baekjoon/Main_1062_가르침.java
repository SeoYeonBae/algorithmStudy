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

		if (K < 5) {	// a, n, t, i, c는 무조건 배워야 해서 보다 K가 작으면 안 됨
			System.out.println(0);
			System.exit(0);
		}

		res = Integer.MIN_VALUE;
		charList = new ArrayList<>();
		combList = new ArrayList<>();
		wordList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();

			word = word.replaceAll("a", "");	// a, n, t, i, c는 이미 배웠다는 가정하에 싹 지워버림
			word = word.replaceAll("n", "");
			word = word.replaceAll("t", "");
			word = word.replaceAll("i", "");
			word = word.replaceAll("c", "");

			wordList.add(word);	// antic 지운 단어를 단어 배열에 저장
			for (int j = 0; j < word.length(); j++) {	// 남은 문자는 배워야 하는 단어니까
				if(!charList.contains(word.charAt(j))) // 중복 없이 저장
					charList.add(word.charAt(j));	
			}
		}
		
		if(K - 5 > charList.size())	// 만약 입력 단어에서 추출한 문자의 수보다 가르칠 수 있는 문자의 수가 많으면
			K = charList.size();	// 입력 단어로부터 뽑아낸 문자의 수로 K를 바꿔치기함
		else
			K -= 5;	// antic는 이미 배웠으니까 얘네 빼고 생각
		
		for (int i = 0; i < K; i++) {	// 조합 만들 때 값 바꿔치기 할 거라 초기값 빈문자로 설정해줌
			combList.add(' ');
		}
		
		comb(0, 0);	
		System.out.println(res);
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void comb(int start, int cnt) {	// 가르쳐야 하는 문자 중에서만 K개의 조합 만들기
		if(cnt == K) {
			check();
			return;
			
		}
		for (int i = start; i < charList.size(); i++) {
			combList.set(cnt, charList.get(i));
			comb(i + 1, cnt + 1);
		}
	}

	private static void check() {	// 문자 조합 만들었으면 몇 개의 단어를 읽을 수 있는지 확인
		int cnt = 0;
		boolean isRead = true;
		for (int i = 0; i < wordList.size(); i++) {	// 단어 수만큼 반복문
			String s = wordList.get(i);
			isRead = true;	// 일단 읽을 수 있다 하고
			for (int j = 0; j < s.length(); j++) {	
				if(!combList.contains(s.charAt(j))) {	// 현재 문자가 가르친 문자 중에 하나라도 없으면
					isRead = false;	// 읽을 수 없는 단어
					break;
				}
			}
			if(isRead)	// 읽을 수 있는 단어일 count 변수 ++
				cnt++;
		}
		res = Math.max(res, cnt); // 맥스값 갱신
		return;
	}
}

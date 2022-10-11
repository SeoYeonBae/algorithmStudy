package baekjoon;

import java.io.*;
import java.util.*;

public class Main_19236_청소년상어 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 일단 물고기 정보는 물고기 번호를 hashmap에 저장
		// 입력은 물고기 번호, 방향 순
		// dr, dc는 물고기 1-8과 동일한 순서로 (반시계방향 회전)
		// 물고기 이동 함수, 상어 이동하고 먹는 함수, hashmap과 물고기 map 복사하는 함수
		// 번호 합의 최댓값 출력
		go();
		br.close();
	}

	private static void go() {
		while(true) {
			moveFish();
			moveShark();			
		}
	}

	private static void moveFish() {
		// TODO Auto-generated method stub
		
	}

	private static void moveShark() {
		// TODO Auto-generated method stub
		
	}

}

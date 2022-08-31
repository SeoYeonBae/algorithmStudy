package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Main_18870_좌표압축 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] tmp = new int[N];
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens())
			nums[cnt] = tmp[cnt++] = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		Arrays.sort(tmp);
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int n : tmp)
			if(!map.containsKey(n))
				map.put(n, cnt++);

		cnt = 0;
		for(int n : nums)
			tmp[cnt++] = map.get(n);
		
		for(int n : tmp)
			sb.append(n).append(" ");
		
		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}

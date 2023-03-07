package Level1;

import java.io.*;
import java.util.StringTokenizer;
	
public class Main_근무시간 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int res = 0;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			String work = st.nextToken();
			String home = st.nextToken();
			
			int workH = Integer.parseInt(work.substring(0, 2));
			int workM = Integer.parseInt(work.substring(3, 5));
			int homeH = Integer.parseInt(home.substring(0, 2));
			int homeM = Integer.parseInt(home.substring(3, 5));
			
			if(homeM < workM) {
				homeH--;
				homeM += 60;
			}
			res = res + (homeM - workM) + ((homeH - workH) * 60);
		}
		System.out.println(res);
	}
}

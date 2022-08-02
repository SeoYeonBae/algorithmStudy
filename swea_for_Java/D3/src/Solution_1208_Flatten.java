import java.io.*;
import java.util.*;

public class Solution_1208_Flatten {

	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		int dump, max, min, res;
		List<Integer> box = new ArrayList<>();
		for (int tc = 1; tc <= 10; tc++) {
			box.removeAll(box);
			dump = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < 100; i++)
				box.add(Integer.parseInt(st.nextToken()));
			
			for(int d = 0; d < dump; d++) {
				max = Collections.max(box);
				min = Collections.min(box);
				box.set(box.indexOf(max), box.get(box.indexOf(max)) - 1);
				box.set(box.indexOf(min), box.get(box.indexOf(min)) + 1);				
			}
			
			res = Collections.max(box) - Collections.min(box);
			result.setLength(0);
			result.append("#").append(tc).append(" ").append(res);

			System.out.println(result);
		}
	}

}

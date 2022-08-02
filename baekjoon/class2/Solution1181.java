// CLASS_2 1181 단어정렬

package algorithmStudy.baekjoon.class2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Set<String> s = new HashSet<>();
		
		for(int i = 0; i < N; i ++)
			s.add(in.readLine());
		
		List<String> tmp = new ArrayList<String>(s);
		Collections.sort(tmp);
		
		List<String> res = new ArrayList<String>();
		for(int i = 1; i <= 50; i++) {
			for(int j = 0; j < tmp.size(); j++) {
				if(tmp.get(j).length() == i) {
					res.add(tmp.get(j));
				}
			}
		}
		
		for(String r : res)
			System.out.println(r);
	}
}

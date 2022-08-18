// CLASS_2 2869 달팽이는 올라가고 싶다

package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2869_달팽이는올라가고싶다 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		double A = Double.parseDouble(st.nextToken());
		double B = Double.parseDouble(st.nextToken());
		double V = Double.parseDouble(st.nextToken());

		int day = (int)Math.ceil((V - B) / (A - B)); 
		System.out.println(day);
	}
}

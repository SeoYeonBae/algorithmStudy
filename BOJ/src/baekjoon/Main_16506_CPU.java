package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16506_CPU {

	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;

		HashMap<String, String> opcodes = new HashMap<>();
		opcodes.put("ADD", "00000");
		opcodes.put("ADDC", "00001");
		opcodes.put("SUB", "00010");
		opcodes.put("SUBC", "00011");
		opcodes.put("MOV", "00100");
		opcodes.put("MOVC", "00101");
		opcodes.put("AND", "00110");
		opcodes.put("ANDC", "00111");
		opcodes.put("OR", "01000");
		opcodes.put("ORC", "01001");
		opcodes.put("NOT", "01010");
		opcodes.put("MULT", "01100");
		opcodes.put("MULTC", "01101");
		opcodes.put("LSFTL", "01110");
		opcodes.put("LSFTLC", "01111");
		opcodes.put("LSFTR", "10000");
		opcodes.put("LSFTRC", "10001");
		opcodes.put("ASFTR", "10010");
		opcodes.put("ASFTRC", "10011");
		opcodes.put("RL", "10100");
		opcodes.put("RLC", "10101");
		opcodes.put("RR", "10110");
		opcodes.put("RRC", "10111");

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			String opcode = st.nextToken();
			String rD = st.nextToken();
			String rA = st.nextToken();
			String rBsharpC = st.nextToken();
			
			sb.append(opcodes.get(opcode)).append("0");
			sb.append(getRegister(rD)).append(getRegister(rA));
			if(opcodes.get(opcode).charAt(4) == '0')
				sb.append(getRegister(rBsharpC)).append("0").append("\n");
			else
				sb.append(getSharpC(rBsharpC)).append("\n");
		}

		br.close();
		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static Object getSharpC(String input) {
		String[] res = {"0", "0", "0", "0"};
		int num = Integer.parseInt(input);
		int index = 3;
		while(num > 1) {
			if(num % 2  == 0)
				res[index] = "0";
			else
				res[index] = "1";
			num /=  2;
			index--;
		}
		if(num == 1)
			res[index] = "1";
		
		return res[0] + res[1] + res[2] + res[3];
	}

	private static String getRegister(String input) {
		String[] res = {"0", "0", "0"};
		int num = Integer.parseInt(input);
		int index = 2;
		while(num > 1) {
			if(num % 2  == 0)
				res[index] = "0";
			else
				res[index] = "1";
			num /=  2;
			index--;
		}
		if(num == 1)
			res[index] = "1";
		System.out.println(Arrays.toString(res));
		return res[0] + res[1] + res[2];
	}
	
}

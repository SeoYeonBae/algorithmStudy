package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_5639_이진검색트리 {

	static class Node{
		int number;
		Node left, right;
		
		Node (int number){
			this.number = number;
		}
		
		Node(int number, Node left, Node right){
			this.number = number;
			this.left = left;
			this.right = right;
		}
		
		void insert(int num) {
			if(num < this.number) {
				if(this.left == null)
					this.left = new Node(num);
				else
					this.left.insert(num);
			}else {
				if(this.right == null)
					this.right = new Node(num);
				else
					this.right.insert(num);
			}
		}
	}
	
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		while(true) {
			String input = br.readLine();
			if(input == null || input.equals(""))
				break;
			root.insert(Integer.parseInt(input));
		}
		
		postOrder(root);
		
		bw.append(sb);
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void postOrder(Node node) {
		if(node == null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);		
		sb.append(node.number).append("\n");
	}
}

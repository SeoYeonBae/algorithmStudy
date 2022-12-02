
public class CompleteBinaryTreeTest {
	
	public static void main(String[] args) {
		
		CompleteBinaryTree tree = new CompleteBinaryTree(9);
		for(int i = 0; i < 9; i++) {
			tree.add((char)('A' + i));
		}
		
//		tree.bfs();
//		tree.bfs2();
//		tree.dfs();

		tree.dfsByPreOrder(1);	// 나를 먼저
		System.out.println();
		tree.dfsByInOrder(1);	// 나를 중간에
		System.out.println();
		tree.dfsByPostOrder(1);	// 나를 마지막에
		System.out.println();
	}
	
}

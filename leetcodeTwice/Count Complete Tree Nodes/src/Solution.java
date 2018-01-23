//Given a complete binary tree, count the number of nodes.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countNodes(TreeNode root) {
		int count = 0;
		int height = getHeight(root);//get the exact height of entire tree;
		while(root != null){
			//when if the height of right subtree is height - 1,that measns the left subtree is a complete tree
			//so we just compute the right part
			//else the height of right subtree not is height - 1,that measns is height - 2,the left subtree is not a complete tree
			//but the right part is a complete which hegith is height - 2;
			if(getHeight(root.right) == (height - 1)){
				count += (1 << (height - 1) - 1 + 1);
				root = root.right;
			}else{
				count += (1 << (height - 2) - 1 + 1);
				root = root.left;
			}
			--height;
		}
		return count;
	}

	public int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		else
			return 1 + getHeight(node.left);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
package models;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static TreeNode newNode(int val) {
		TreeNode node = new TreeNode();
		node.val = val;
		node.left = node.right = null;
		return (node);
	}
}

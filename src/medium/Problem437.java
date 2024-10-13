package medium;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Problem437 {

	static TreeNode newNode(int val) {
		TreeNode node = new TreeNode();
		node.val = val;
		node.left = node.right = null;
		return (node);
	}

	// https://leetcode.com/problems/path-sum-iii/
	public static int count(TreeNode node, long sum) {
		if (node == null)
			return 0;
		int increase = node.val == sum ? 1 : 0;
		return increase + count(node.left, sum - node.val) + count(node.right, sum - node.val);
	}

	public static int pathSum(TreeNode node, long sum) {
		if (node == null)
			return 0;
		return count(node, sum) + pathSum(node.left, sum) + pathSum(node.right, sum);
	}

	public static void main(String[] args) {
		// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
		// Output: 3
//		TreeNode node = newNode(10);
//		node.left = newNode(5);
//		node.right = newNode(-3);
//		node.left.left = newNode(3);
//		node.left.right = newNode(2);
//		node.right.right = newNode(11);
//		node.left.left.left = newNode(3);
//		node.left.left.right = newNode(-2);
//		node.left.right.right = newNode(1);
//		System.out.println(pathSum(node, 8));

		// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
		// Output: 3
//		TreeNode node = newNode(5);
//		node.left = newNode(4);
//		node.right = newNode(8);
//		node.left.left = newNode(11);
//		node.right.left = newNode(13);
//		node.right.right = newNode(4);
//		node.left.left.left = newNode(7);
//		node.left.left.right = newNode(2);
//		node.right.right.left = newNode(5);
//		node.right.right.right = newNode(1);
//		System.out.println(pathSum(node, 22));

		// Input:
		// [1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000],
		// targetSum = 0
		// Output: 0
		TreeNode node = newNode(1000000000);
		node.left = newNode(1000000000);
		node.left.left = newNode(294967296);
		node.left.left.left = newNode(1000000000);
		node.left.left.left.left = newNode(1000000000);
		node.left.left.left.left.left = newNode(1000000000);
		System.out.println(pathSum(node, 0));

		// Input: [0,1,1], targetSum = 0
		// Output: 1
//		TreeNode node = newNode(0);
//		node.left = newNode(1);
//		node.right = newNode(1);
//		System.out.println(pathSum(node, 0));
	}

}

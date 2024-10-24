package medium;

import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.Map;
//import java.util.Optional;

import models.TreeNode;

// https://leetcode.com/problems/cousins-in-binary-tree-ii/description/?envType=daily-question&envId=2024-10-23

public class Problem2641 {

	public static void getSum(TreeNode node, int level, HashMap<Integer, Integer> preSum) {
		if (node == null)
			return;
		int sum = preSum.getOrDefault(level, 0) + node.val;
		preSum.put(level, sum);
		getSum(node.left, level + 1, preSum);
		getSum(node.right, level + 1, preSum);
	}

	public static TreeNode dfs1(TreeNode r, int l, TreeNode curr, HashMap<Integer, Integer> m) {
		int sum_of_cousins = m.getOrDefault(l + 1, 0) - ((r.left != null) ? r.left.val : 0)
				- ((r.right != null) ? r.right.val : 0);
		if (r.left != null) {
			curr.left = TreeNode.newNode(sum_of_cousins);
			dfs1(r.left, l + 1, curr.left, m);
		}
		if (r.right != null) {
			curr.right = TreeNode.newNode(sum_of_cousins);
			dfs1(r.right, l + 1, curr.right, m);
		}
		return curr;
	}

	public static TreeNode replaceValueInTree(TreeNode root) {
		HashMap<Integer, Integer> preSum = new HashMap<>(); // level-parent: sum
		getSum(root, 1, preSum);
		// {1=5, 2=13, 3=18}
		return dfs1(root, 1, TreeNode.newNode(0), preSum);
	}

	public static void main(String[] args) {
		// Input: root = [5,4,9,1,10,null,7]
		// Output: [0,0,0,7,7,null,11]
		TreeNode node = TreeNode.newNode(5);
		node.left = TreeNode.newNode(4);
		node.right = TreeNode.newNode(9);
		node.left.left = TreeNode.newNode(1);
		node.left.right = TreeNode.newNode(10);
		node.right.right = TreeNode.newNode(7);
		replaceValueInTree(node);

		// [904,416,765,705,null,null,14,null,null,821,754,774,30,null,548
		// ,905,879,363,130,494,null,null,451,327,414,null,null,null,null
		// ,41,null,471,null,703,null,null,null,null,null,574,null,41,895
		// ,null,214,null,365]

		System.out.println();
	}

}

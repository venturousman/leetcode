package medium;

//import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import models.TreeNode;

// https://leetcode.com/problems/path-sum-ii/description/

public class Problem113 {

	public static void helper(TreeNode node, int targetSum, int currSum, List<Integer> path,
			List<List<Integer>> paths) {
		if (node == null)
			return;

		int newSum = currSum + node.val;

		if (newSum == targetSum && node.left == null && node.right == null) {
			// is leaf
			List<Integer> p = new ArrayList<>(path);
			p.add(node.val);
			paths.add(p);
			return;
		}

		path.add(node.val);
		if (node.left != null)
			helper(node.left, targetSum, newSum, path, paths);
		if (node.right != null)
			helper(node.right, targetSum, newSum, path, paths);
		path.removeLast();
	}

	public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper(root, targetSum, 0, path, paths);
		return paths;
	}

	public static void main(String[] args) {
		// Input: root = [-2,null,-3], targetSum = -5
		// Output: [[-2,-3]]
		TreeNode node = TreeNode.newNode(-2);
		node.right = TreeNode.newNode(-3);
		System.out.println(pathSum(node, -5));

		// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
		// Output: [[5,4,11,2],[5,8,4,5]]
//		TreeNode node = TreeNode.newNode(5);
//		node.left = TreeNode.newNode(4);
//		node.right = TreeNode.newNode(8);
//		node.left.left = TreeNode.newNode(11);
//		node.right.left = TreeNode.newNode(13);
//		node.right.right = TreeNode.newNode(4);
//		node.left.left.left = TreeNode.newNode(7);
//		node.left.left.right = TreeNode.newNode(2);
//		node.right.right.left = TreeNode.newNode(5);
//		node.right.right.right = TreeNode.newNode(1);
//		System.out.println(pathSum(node, 22));

		// Input: root = [1,2,3], targetSum = 5
		// Output: []
//		TreeNode node = TreeNode.newNode(1);
//		node.left = TreeNode.newNode(2);
//		node.right = TreeNode.newNode(3);
//		System.out.println(pathSum(node, 5));

		// Input: root = [1,2], targetSum = 0
		// Output: []
//		TreeNode node = TreeNode.newNode(1);
//		node.left = TreeNode.newNode(2);
//		System.out.println(pathSum(node, 0));
	}

}

package medium;

import models.TreeNode;

public class Problem951 {

	public static boolean isEqual(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return (isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right))
				|| (isEqual(root1.left, root2.right) && isEqual(root1.right, root2.left));
	}

	public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		return isEqual(root1, root2);
	}

	public static void main(String[] args) {
		// root1 [1,2,3,4,5,6,null,null,null,7,8]
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.left.right.left = new TreeNode(7);
		root1.left.right.right = new TreeNode(8);

		// root2 [1,3,2,null,6,4,5,null,null,null,null,8,7]
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		root2.left.right = new TreeNode(6);
		root2.right.left = new TreeNode(4);
		root2.right.right = new TreeNode(5);
		root2.right.right.left = new TreeNode(8);
		root2.right.right.right = new TreeNode(7);
		
		System.out.println(flipEquiv(root1, root2));
		System.out.println(flipEquiv(null, null));
		System.out.println(flipEquiv(null, new TreeNode(1)));
	}

}

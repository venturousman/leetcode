package medium;

import java.util.HashMap;
import java.util.PriorityQueue;

import models.TreeNode;

// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/?envType=daily-question&envId=2024-10-22

public class Problem2583 {

	public static void getSum(TreeNode node, int level, HashMap<Integer, Long> preSum) {
		if (node == null)
			return;
		long sum = preSum.getOrDefault(level, 0L) + node.val;
		preSum.put(level, sum);
		getSum(node.left, level + 1, preSum);
		getSum(node.right, level + 1, preSum);
	}

	public static long kthLargestLevelSum(TreeNode root, int k) {
		HashMap<Integer, Long> preSum = new HashMap<>(); // level: sum
		getSum(root, 1, preSum);
		// {1=5, 2=17, 3=13, 4=10}
		// Return the kth largest level sum in the tree (not necessarily distinct). 
		// If there are fewer than k levels in the tree, return -1.
		if (preSum.size() < k) return -1;
		
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);

        // Add elements to the heap
        for (Long num : preSum.values()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();  // Remove the smallest element if heap size exceeds k
            }
        }

        // The root of the heap is the k-th largest element
        var result = minHeap.peek();
		return result;
	}

	public static void main(String[] args) {
		// Input: root = [5,8,9,2,1,3,7,4,6], k = 2
		// Output: 13
		TreeNode node = TreeNode.newNode(5);
		node.left = TreeNode.newNode(8);
		node.right = TreeNode.newNode(9);
		node.left.left = TreeNode.newNode(2);
		node.left.right = TreeNode.newNode(1);
		node.right.left = TreeNode.newNode(3);
		node.right.right = TreeNode.newNode(7);
		node.left.left.left = TreeNode.newNode(4);
		node.left.left.right = TreeNode.newNode(6);
		System.out.println(kthLargestLevelSum(node, 2));
	}

}

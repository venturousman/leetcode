package leetcode;

public class Problem540 {

	public static int singleNonDuplicate(int[] nums) {
//		int left = 0, right = nums.length - 1;
//		while (left < right) {
//			int mid = (left + right) / 2;
//			if (mid % 2 == 1) {
//				mid--;
//			}
//			if (nums[mid] != nums[mid + 1]) {
//				right = mid;
//			} else {
//				left = mid + 2;
//			}
//		}
//		return nums[left];
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1]))
				left = mid + 1;
			else
				right = mid;
		}
		return nums[left];
	}

	/*
	 * EXPLANATION:- Suppose array is [1, 1, 2, 2, 3, 3, 4, 5, 5] we can observe
	 * that for each pair, first element takes even position and second element
	 * takes odd position for example, 1 is appeared as a pair, so it takes 0 and 1
	 * positions. similarly for all the pairs also.
	 * 
	 * this pattern will be missed when single element is appeared in the array.
	 * 
	 * From these points, we can implement algorithm. 
	 * 1. Take left and right pointers 
	 * . left points to start of list
	 * . right points to end of the list. 
	 * 2. find mid. 
	 * if mid is even, then it's duplicate should be in next index. 
	 * or if mid is odd, then it's duplicate should be in previous index. 
	 * check these two conditions, if any of the conditions is satisfied, 
	 * then pattern is not missed, so check in next half of the array. i.e, left = mid + 1 
	 * if condition is not satisfied, then the pattern is missed. so, single number must be before mid. so, update right to mid. 
	 * 3. At last return the nums[left]
	 */

	public static void main(String[] args) {
		System.out.println("Case 1: " + singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 }));
		System.out.println("Case 2: " + singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 }));
		System.out.println("Case 2: " + singleNonDuplicate(new int[] { 1, 3, 3, 7, 7, 11, 11 }));
	}

}

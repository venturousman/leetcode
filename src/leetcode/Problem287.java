package leetcode;

public class Problem287 {

	public static int findDuplicate(int[] nums) {
		boolean[] check = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			if (check[nums[i]])
				return nums[i];
			check[nums[i]] = true;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println("nums=[1,3,4,2,2]: " + findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println("nums=[3,1,3,4,2]: " + findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		System.out.println("nums=[3,3,3,3,3]: " + findDuplicate(new int[] { 3, 3, 3, 3, 3 }));
	}

}

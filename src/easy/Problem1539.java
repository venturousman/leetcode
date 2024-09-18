package easy;

public class Problem1539 {

	public static int findKthPositive(int[] arr, int k) {
		int res = k;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > res)
				break;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("arr=[2,3,4,7,11], k=5: " + findKthPositive(new int[] { 2, 3, 4, 7, 11 }, 5));
		System.out.println("arr=[1,2,3,4], k=2: " + findKthPositive(new int[] { 1, 2, 3, 4 }, 2));
	}
}
/*
 * Explanation: The array is strictly increasing - no repeating values. One case
 * is, that the first element in the array is larger than k - which means all
 * elements are larger than k. In this case the answer will be k. For example:
 * arr = [5,6,7,8] k = 3 the missing numbers are: [1,2,3,4] third missing number
 * is 3 = k. Now, for every element that is smaller than k, if we increment k -
 * we'll get the right answer at the end.
 */

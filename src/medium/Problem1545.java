package medium;

// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/?envType=daily-question&envId=2024-10-19
// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/solutions/5934232/beats-100-00-step-by-step-breakdown/?envType=daily-question&envId=2024-10-19

public class Problem1545 {

	public static char findKthBit(int n, int k) {
		// Base case: When n = 1, the binary string is "0"
		if (n == 1)
			return '0';

		// Find the length of the current string Sn, which is 2^n - 1
		int length = (1 << n) - 1; // left shift operator
		// Left shift: x << n is equivalent to x * 2^n.

		// Find the middle position
		int mid = length / 2 + 1;

		// If k is the middle position, return '1'
		if (k == mid)
			return '1';

		// If k is in the first half, find the bit in Sn-1
		if (k < mid)
			return findKthBit(n - 1, k);

		// If k is in the second half, find the bit in Sn-1 and invert it
		return findKthBit(n - 1, length - k + 1) == '0' ? '1' : '0';
	}

	public static void main(String[] args) {
		System.out.println(findKthBit(3, 1)); // '0'
		System.out.println(findKthBit(4, 11)); // '1' - s4 = 0111001 1 0110001
		System.out.println(findKthBit(20, 1048575)); // ''
	}

}

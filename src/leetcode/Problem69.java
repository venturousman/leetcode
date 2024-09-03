package leetcode;

public class Problem69 {

	public static int mySqrt(int x) {
		if (x == 0 || x == 1)
			return x;
		long left = 1;
		long right = (x / 2);
		long xl = x;
		while (left <= right) {
			// int mid = (left + (right - left) / 2);
			long mid = (right + left) / 2;
			long mid2 = mid * mid;
			// System.out.println("1. " + left + " - " + right + " - " + mid);
			if (mid2 == xl)
				return (int) mid;
			if (mid2 > xl)
				right = mid - 1;
			else
				left = mid + 1;
			// System.out.println("2. " + left + " - " + right);
		}
		// System.out.println("3. " + left + " - " + right);
		return left * left == x ? (int) left : (int) left - 1;
	}

	public static void main(String[] args) {
		System.out.println("Case 1: " + mySqrt(4));
		System.out.println("Case 2: " + mySqrt(8));
	}

}

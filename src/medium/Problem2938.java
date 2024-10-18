package medium;

// https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15

public class Problem2938 {

	public static long minimumSteps(String s) {
		var sb = new StringBuilder(s);
		int l = 0;
		int r = sb.length() - 1;
		long count = 0;
		while (l < r) {
			while (l < sb.length() && sb.charAt(l) == '0')
				l++;
			while (r >= 0 && sb.charAt(r) == '1')
				r--;
			if (l < r) {
				char tmp = sb.charAt(l);
				sb.setCharAt(l, sb.charAt(r));
				sb.setCharAt(r, tmp);
				count += r - l;
			}
		}
		return count;
	}

	public static void main(String[] args) {
//		System.out.println(minimumSteps("101")); // 1
//		System.out.println(minimumSteps("100")); // 2
//		System.out.println(minimumSteps("110")); // 2
//		System.out.println(minimumSteps("0111")); // 0
	}

}

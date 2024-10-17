package medium;

// https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16

public class Problem1405 {

	public static String longestDiverseString(StringBuilder x, StringBuilder y, StringBuilder z) {
		var s = new StringBuilder();

		while (x.length() > 0 || y.length() > 0 || z.length() > 0) {
			if (s.length() == 0 || (s.length() > 0 && x.length() > 0 && s.charAt(s.length() - 1) != x.charAt(0))) {
				int size = Math.min(2, x.length());
				for (int i = 0; i < size; i++) {
					s.append(x.charAt(0));
					x.deleteCharAt(0);
				}
			} else {
				if (x.length() > 0)
					x.deleteCharAt(0);
			}

			if (s.length() == 0 || (s.length() > 0 && y.length() > 0 && s.charAt(s.length() - 1) != y.charAt(0))) {
				int size = Math.min(2, y.length());
				for (int i = 0; i < size; i++) {
					s.append(y.charAt(0));
					y.deleteCharAt(0);
				}
			} else {
				if (y.length() > 0)
					y.deleteCharAt(0);
			}

			if (s.length() == 0 || (s.length() > 0 && z.length() > 0 && s.charAt(s.length() - 1) != z.charAt(0))) {
				int size = Math.min(2, z.length());
				for (int i = 0; i < size; i++) {
					s.append(z.charAt(0));
					z.deleteCharAt(0);
				}
			} else {
				if (z.length() > 0)
					z.deleteCharAt(0);
			}
		}

		var res = s.toString();
//		System.out.println(res);
		return res;
	}

	public static String longestDiverseString(int a, int b, int c) {
		var x = new StringBuilder();
		var y = new StringBuilder();
		var z = new StringBuilder();

		if (a >= b && a >= c) {
			for (int i = 0; i < a; i++) {
				x.append('a');
			}
			if (b >= c) {
				for (int i = 0; i < b; i++) {
					y.append('b');
				}
				for (int i = 0; i < c; i++) {
					z.append('c');
				}
			} else {
				for (int i = 0; i < c; i++) {
					y.append('c');
				}
				for (int i = 0; i < b; i++) {
					z.append('b');
				}
			}
		} else if (b >= a && b >= c) {
			for (int i = 0; i < b; i++) {
				x.append('b');
			}
			if (a >= c) {
				for (int i = 0; i < a; i++) {
					y.append('a');
				}
				for (int i = 0; i < c; i++) {
					z.append('c');
				}
			} else {
				for (int i = 0; i < c; i++) {
					y.append('c');
				}
				for (int i = 0; i < a; i++) {
					z.append('a');
				}
			}
		} else if (c >= a && c >= b) {
			for (int i = 0; i < c; i++) {
				x.append('c');
			}
			if (a >= b) {
				for (int i = 0; i < a; i++) {
					y.append('a');
				}
				for (int i = 0; i < b; i++) {
					z.append('b');
				}
			} else {
				for (int i = 0; i < b; i++) {
					y.append('b');
				}
				for (int i = 0; i < a; i++) {
					z.append('a');
				}
			}
		}

		return longestDiverseString(x, y, z);
	}

	public static void main(String[] args) {
		System.out.println(longestDiverseString(1, 1, 7)); // ccaccbcc
//		System.out.println(longestDiverseString(7, 1, 0)); // aabaa
//		System.out.println(longestDiverseString(2, 2, 1)); // aabbc
//		System.out.println(longestDiverseString(5, 4, 3)); // output: aabaababbcc - expected: aabbaaccbbac
	}

}

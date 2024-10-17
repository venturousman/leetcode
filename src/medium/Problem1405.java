package medium;

public class Problem1405 {

	public static String longestDiverseString(int a, int b, int c) {
		var s = new StringBuilder();
		// init
		if (a >= b && a >= c) {
			for (int i = 0; i < a; i++) {
				s.append('a');
			}
			if (b >= c) {
				for (int i = 0; i < b; i++) {
					s.append('b');
				}
				for (int i = 0; i < c; i++) {
					s.append('c');
				}
			} else {
				for (int i = 0; i < c; i++) {
					s.append('c');
				}
				for (int i = 0; i < b; i++) {
					s.append('b');
				}
			}
		} else if (b >= a && b >= c) {
			for (int i = 0; i < b; i++) {
				s.append('b');
			}
			if (a >= c) {
				for (int i = 0; i < a; i++) {
					s.append('a');
				}
				for (int i = 0; i < c; i++) {
					s.append('c');
				}
			} else {
				for (int i = 0; i < c; i++) {
					s.append('c');
				}
				for (int i = 0; i < a; i++) {
					s.append('a');
				}
			}
		} else if (c >= a && c >= b) {
			for (int i = 0; i < c; i++) {
				s.append('c');
			}
			if (a >= b) {
				for (int i = 0; i < a; i++) {
					s.append('a');
				}
				for (int i = 0; i < b; i++) {
					s.append('b');
				}
			} else {
				for (int i = 0; i < b; i++) {
					s.append('b');
				}
				for (int i = 0; i < a; i++) {
					s.append('a');
				}
			}
		}
//		System.out.println(s.toString());

		if (s.length() < 3) {
			return s.toString();
		} else if (s.length() == 3) {
			if (s.charAt(0) == s.charAt(1) && s.charAt(0) == s.charAt(2)) {
				s.deleteCharAt(2);
			}
			return s.toString();
		} else {
			// s.length() > 3
			int i = 2;
			while (i < s.length()) {
				if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
					int k = i + 1;
					while (k < s.length() && s.charAt(k) == s.charAt(i))
						k++;
					if (k < s.length()) {
						// swap
						var x = s.charAt(i);
						s.setCharAt(i, s.charAt(k));
						s.setCharAt(k, x);
					} else if (k == s.length()) {
//						s.deleteCharAt(i);
						s.delete(i, k);
					}
				}
				i += 1;
			}
		}

		var res = s.toString();
//		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
//		System.out.println(longestDiverseString(1, 1, 7));
//		System.out.println(longestDiverseString(7, 1, 0));
//		System.out.println(longestDiverseString(2, 2, 1)); // aabbc
		System.out.println(longestDiverseString(5, 4, 3)); // output: aabaababbcc - expected: aabbaaccbbac
	}

}

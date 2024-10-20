package medium;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/
// contest 420

public class Problem3324 {

	// Q1 - accepted
	public static List<String> stringSequence(String target) {
		List<String> results = new ArrayList<>();
		var chars = target.toCharArray();
		var s = new StringBuilder("a");
		results.add(s.toString());
		for (int i = 0; i < chars.length; i++) {
			var c = chars[i];
			if (i + 1 > s.length()) {
				// key 1
				s.append("a");
				results.add(s.toString());
			}

			// key 2
			var lastC = s.charAt(s.length() - 1);
			while (lastC != c) {
				lastC++;
				s.setCharAt(s.length() - 1, lastC);
				results.add(s.toString());
			}
		}
		return results;
	}

	public static void main(String[] args) {
		System.out.println(stringSequence("abc"));
		System.out.println(stringSequence("he"));
	}
}

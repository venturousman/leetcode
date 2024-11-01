package easy;

// https://leetcode.com/problems/delete-characters-to-make-fancy-string/?envType=daily-question&envId=2024-11-01

public class Problem1957 {

	public static String makeFancyString1(String s) {
		var sb = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			sb.append(s.charAt(i));
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				sb.append(s.charAt(i + 1));
				int j = i + 2;
				while (j < s.length() && s.charAt(j) == s.charAt(i))
					j++;
				i = j;
				continue;
			}
			i++;
		}
		return sb.toString();
	}

	public static String makeFancyString(String s) {
		int sameCount = 0;
		StringBuilder sb = new StringBuilder();
		char prev = s.charAt(0);
		for (char cur : s.toCharArray()) {
			if (cur == prev) {
				sameCount++;
			} else {
				sameCount = 1;
			}
			if (sameCount < 3)
				sb.append(cur);
			prev = cur;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(makeFancyString("leeetcode")); // expected: leetcode
		System.out.println(makeFancyString("aaabaaaa")); // expected: aabaa
		System.out.println(makeFancyString("aab")); // expected: aab
		System.out.println(makeFancyString("abbcccddddeeeee")); // expected: abbccddee
	}

}

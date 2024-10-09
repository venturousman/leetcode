package medium;

public class Problem3297 {

	// https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/
	// https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/solutions/5818284/sliding-window-with-example-walkthrough/
	public static long validSubstringCount(String word1, String word2) {
		// First, we calculate the frequency of each character in word2
		// and store it in a frequency vector v of size 26 lowercase letters.
		int[] v = new int[26];
		for (char c : word2.toCharArray()) {
			v[c - 'a']++;
		}

		int[] cnt = new int[26]; // a window keeps track of character frequencies in word1
		int start = 0;
		/*
		 * k: represents how many characters in word2 are not matched yet within the
		 * window. Initially, k = length(word2), and it decreases as we match characters
		 * of word2 inside the current window of word1. When k == 0, it means the
		 * current window of word1 contains enough characters to potentially be
		 * rearranged into a valid substring that starts with word2.
		 */
		int k = word2.length();
		long count = 0;

		for (int i = 0; i < word1.length(); i++) {
			char curr = word1.charAt(i);
			if (v[curr - 'a'] > 0) {
				if (cnt[curr - 'a'] < v[curr - 'a']) {
					k--;
				}
			}

			cnt[curr - 'a']++;

			while (k == 0) {
				count += word1.length() - i;
				char pre = word1.charAt(start);
				cnt[pre - 'a']--;
				if (v[pre - 'a'] > 0 && cnt[pre - 'a'] < v[pre - 'a']) {
					k++;
				}
				start++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(validSubstringCount("bcca", "abc"));
		System.out.println(validSubstringCount("abcabc", "abc"));
		System.out.println(validSubstringCount("abcabc", "aaabc"));
		System.out.println(validSubstringCount("bbbb", "b"));
		System.out.println(validSubstringCount("oooooooooo", "o"));

//		System.out.println(getSubStrings("bcca", 3));
//		System.out.println(getSubStrings("abcabc", 3));
//		System.out.println(getSubStrings("abcabc", 5));
//		System.out.println(getSubStrings("bbbb", 1));
	}

}

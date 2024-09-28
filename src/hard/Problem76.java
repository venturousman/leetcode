package hard;

public class Problem76 {

	// https://www.geeksforgeeks.org/ascii-table/
	// https://leetcode.com/problems/minimum-window-substring/
	public static String minWindow(String word1, String word2) {
		int size = 58; // not 26; [A-Z] and [a-z]
		char initialC = 'A'; // not 'a'
		int[] v = new int[58];
		for (char c : word2.toCharArray()) {
			v[c - initialC]++;
		}

		int[] cnt = new int[58]; // a window keeps track of character frequencies in word1
		int start = 0;
		int k = word2.length();
//		long count = 0;
		
		String res = "";
		int minLen = word1.length();

		for (int i = 0; i < word1.length(); i++) {
			char curr = word1.charAt(i);
			if (v[curr - initialC] > 0) {
				if (cnt[curr - initialC] < v[curr - initialC]) {
					k--;
				}
			}

			cnt[curr - initialC]++;

			while (k == 0) {
				// calculate
				int len = i - start + 1;
				if (len <= minLen) {
					minLen = len;
					res = word1.substring(start, i + 1);
				}
//				count += word1.length() - i;
				
				// new round
				char pre = word1.charAt(start);
				cnt[pre - initialC]--;
				if (v[pre - initialC] > 0 && cnt[pre - initialC] < v[pre - initialC]) {
					k++;
				}
				start++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(minWindow("a", "a"));
		System.out.println(minWindow("a", "aa"));
	}

}

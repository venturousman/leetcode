package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.ListSelectionEvent;

public class Problem3297 {

	public static void swap(int a[], int from, int to) {
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}

	public static void reverse(int a[], int from, int to) {
		int b = from, e = to;
		while (b < e) {
			swap(a, b, e);
			b++;
			e--;
		}
	}

	// Liet ke hoan vi
	public static boolean nextGeneration(int b[], int n) {
		int i = n - 1;
		while (i > 0 && b[i] > b[i + 1])
			i--;
		if (i == 0)
			return false;

		int k = n;
		while (b[k] < b[i])
			k--;

		// if(k==i) return 0;

		swap(b, k, i);
		reverse(b, i + 1, n);

		return true;
	}

	public static int[] firstGeneration(String word1, int n) {
		int max = 100000;
		int size = n;
		if (n > max)
			size = max;
		int[] a = new int[max + 1];
		for (int i = 1; i <= size; i++)
			a[i] = i;
		return a;
	}

	public static String getString(String word1, int[] generation, int n) {
		StringBuilder s = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			int idx = generation[i] - 1;
			var c = word1.charAt(idx);
			s.append(c);
		}
		return s.toString();
	}

//	public static boolean isValid(String word1, String word2) {
//		return word1.startsWith(word2);
//	}
	
	public static boolean isValid2(String word1, String word2) {
		for (int i = 0; i < word2.length(); i++) {
			var c = word2.charAt(i) + "";
			if (!word1.contains(c)) return false;
		}
		return true;
	}

	public static boolean isValidGeneration(int[] gen, int n) {
		for (int i = 1; i < n; i++) {
			var index = gen[i];
			var nextIndex = gen[i + 1];
			if (index == n && nextIndex != 1)
				return false;
			if (index < n && nextIndex != index + 1)
				return false;
		}
		return true;
	}

	public static void printList(int[] a, int n) {
		for (int i = 1; i <= n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static List<String> getSubStrings(String s, int size) {
		List<String> subs = new ArrayList<>();
		int len = s.length();
		for (int k = size; k <= len; k++) {
			for (int i = 0; i <= len - k; i++) {
				var sub = s.substring(i, i + k);
				subs.add(sub);
			}
		}
		return subs;
	}

	public static List<String> getGenerations(String word, int n) {
		List<String> strings = new ArrayList<>();
		int[] generation = firstGeneration(word, n);

		do {
			String s = getString(word, generation, n);
//			printList(generation, n);
//			System.out.println(s + "\n");
			strings.add(s);
		} while (nextGeneration(generation, n));
		return strings;
	}

	// https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/description/
	public static long validSubstringCount(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		if (len1 < len2)
			return 0;

		long count = 0;

//		var strings = getGenerations(word2, len2);
//		System.out.println(strings + " - " + strings.size());

		var subStrings = getSubStrings(word1, len2);
//		System.out.println(subStrings + " - " + subStrings.size());

		for (int i = 0; i < subStrings.size(); i++) {
			var subString = subStrings.get(i);
//			System.out.println(subString);
			
			if (!isValid2(subString, word2))
				continue;
			
			var generations = getGenerations(subString, subString.length());
//			System.out.println(generations + " - " + generations.size());

//			for (int j = 0; j < generations.size(); j++) {
//				var gen = generations.get(j);
//				if (gen.startsWith(word2))
//					count++;
//			}

	        boolean anyMatch = generations.stream().anyMatch(g -> g.startsWith(word2));
//	        boolean anyMatch = strings.stream().anyMatch(s -> subString.contains(s));
	        if (anyMatch) count ++;

			/*
			 * int n = subString.length(); Set<String> set = new HashSet<>();
			 * 
			 * int[] generation = firstGeneration(subString, n);
			 * 
			 * do { // printList(generation, n); var isOk = isValidGeneration(generation,
			 * n); // System.out.println("Ok: " + isOk); if (!isOk) continue; String s =
			 * getString(subString, generation, n); // printList(generation, n); //
			 * System.out.println(s + "\n"); if (isValid(s, word2)) { set.add(s); //
			 * printList(generation, n); // System.out.println(s + "\n"); } } while
			 * (nextGeneration(generation, n));
			 * 
			 * count += set.size(); // if (subString.contains(word2)) count+= 1;
			 */
		}

//		System.out.println("count: " + count);
		return count;
	}

	public static void main(String[] args) {
//		System.out.println(validSubstringCount("bcca", "abc"));
//		System.out.println(validSubstringCount("abcabc", "abc"));
//		System.out.println(validSubstringCount("abcabc", "aaabc"));
//		System.out.println(validSubstringCount("bbbb", "b"));
		System.out.println(validSubstringCount("oooooooooo", "o"));
		
//		System.out.println(getSubStrings("bcca", 3));
//		System.out.println(getSubStrings("abcabc", 3));
//		System.out.println(getSubStrings("abcabc", 5));
//		System.out.println(getSubStrings("bbbb", 1));
	}

}

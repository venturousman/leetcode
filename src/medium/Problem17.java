package medium;

import java.util.ArrayList;
import java.util.List;

public class Problem17 {

	private static String[] mapping = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public static List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return new ArrayList<>();
		List<String> result = new ArrayList<>();
		backtrack(result, digits, 0, new StringBuilder());
		return result;
	}

	private static void backtrack(List<String> result, String digits, int idx, StringBuilder comb) {
		if (comb.length() == digits.length()) {
			result.add(comb.toString());
			return;
		}

		int arrIdx = digits.charAt(idx) - '2';
		for (char ch : mapping[arrIdx].toCharArray()) {
			comb.append(ch);
			backtrack(result, digits, idx + 1, comb);
			comb.setLength(comb.length() - 1);
		}
	}

	// 1st way
	/*
	 * public static HashMap<String, String[]> generateMap() { // Initialize HashMap
	 * HashMap<String, String[]> map = new HashMap<>();
	 * 
	 * // Add entries to the HashMap map.put("2", new String[] { "a", "b", "c" });
	 * map.put("3", new String[] { "d", "e", "f" }); map.put("4", new String[] {
	 * "g", "h", "i" }); map.put("5", new String[] { "j", "k", "l" }); map.put("6",
	 * new String[] { "m", "n", "o" }); map.put("7", new String[] { "p", "q", "r",
	 * "s" }); map.put("8", new String[] { "t", "u", "v" }); map.put("9", new
	 * String[] { "w", "x", "y", "z" });
	 * 
	 * return map; }
	 * 
	 * public static void Try(String digits, HashMap<String, String[]> map,
	 * StringBuilder current, int i, List<String> generations) { if (i >=
	 * digits.length()) { generations.add(current.toString()); return; } var c =
	 * digits.charAt(i) + ""; var options = map.get(c); for (int j = 0; j <
	 * options.length; j++) { var item = options[j]; current.append(item);
	 * Try(digits, map, current, i + 1, generations);
	 * current.deleteCharAt(current.length() - 1); } }
	 * 
	 * public static List<String> letterCombinations(String digits) { List<String>
	 * generations = new ArrayList<>(); if (digits == null || digits.isEmpty() ||
	 * digits.isBlank()) return generations; HashMap<String, String[]> map =
	 * generateMap(); var current = new StringBuilder(); Try(digits, map, current,
	 * 0, generations); return generations; }
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Example 1: " + letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
		System.out.println("Example 2: " + letterCombinations("")); // []
		System.out.println("Example 3: " + letterCombinations("2")); // ["a","b","c"]
	}

}

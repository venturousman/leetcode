package easy;

public class Problem796 {

	public static boolean rotateString1(String s, String goal) {
		if (s.length() != goal.length())
			return false;

		if (s.equals(goal))
			return true;

		// loop max N times
		var ss = s;
		for (int i = 0; i < s.length(); i++) {
			ss = ss.substring(1) + ss.charAt(0);
			if (ss.equals(goal))
				return true;
		}

		return false;
	}

	public static boolean rotateString(String s, String goal) {
		if (s.length() != goal.length())
			return false;
		String str = s + s;
		if (str.contains(goal))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(rotateString("abcde", "cdeab")); // true
		System.out.println(rotateString("abcde", "abced")); // false
		System.out.println(rotateString("defdefdefabcabc", "defdefabcabcdef")); // true
	}

}

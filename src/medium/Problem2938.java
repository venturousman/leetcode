package medium;

// https://leetcode.com/problems/separate-black-and-white-balls/description/?envType=daily-question&envId=2024-10-15

public class Problem2938 {

	// https://leetcode.com/problems/separate-black-and-white-balls/solutions/5913694/beats-100-easy-counter-solution-python-java-c/?envType=daily-question&envId=2024-10-15
	public static long minimumSteps(String s) {
		long swap = 0; // count
		int black = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') // encounter white ball '0'
				swap += (long) black;
			else
				black++; // encounter black ball '1'
		}
		return swap;
	}

	public static void main(String[] args) {
		System.out.println(minimumSteps("101")); // 1
		System.out.println(minimumSteps("100")); // 2
		System.out.println(minimumSteps("110")); // 2
		System.out.println(minimumSteps("0111")); // 0
	}

}

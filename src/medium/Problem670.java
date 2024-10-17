package medium;

// https://leetcode.com/problems/maximum-swap/description/?envType=daily-question&envId=2024-10-17

public class Problem670 {

	public static int maximumSwap(int num) {
        var s = new StringBuilder(num + "");
        for (int i = 0; i < s.length() - 1; i++) {
            int idx = i + 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) >= s.charAt(idx)) {
                    idx = j;
                }
            }
            if (s.charAt(i) < s.charAt(idx)) {
                char tmp = s.charAt(i);
                s.setCharAt(i, s.charAt(idx));
                s.setCharAt(idx, tmp);
                break;
            }
        }

        // System.out.println(s);
        var res = Integer.parseInt(s.toString());
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(maximumSwap(2736));
		System.out.println(maximumSwap(9973));
		System.out.println(maximumSwap(10));
		System.out.println(maximumSwap(100));
		System.out.println(maximumSwap(98368));
		System.out.println(maximumSwap(1993));
	}

}

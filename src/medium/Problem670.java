package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-swap/description/?envType=daily-question&envId=2024-10-17

public class Problem670 {

	public static int maximumSwap1(int num) {
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

	public static int maximumSwap(int num) {
		List<Integer> arr = new ArrayList<>();
		int x = num;
		while (x > 0) {
			arr.add(x % 10);
			x /= 10;
		}
		int idx = -1;
		int idy = -1;
		int max = -1;
		for (int i = 0; i < arr.size(); i++) {
			if (max == -1 || arr.get(max) < arr.get(i)) {
				max = i;
			} else if (arr.get(max) > arr.get(i)) {
				idx = i;
				idy = max;
			}
		}
		if (idx != -1 && idy != -1) {
			int temp = arr.get(idx);
			arr.set(idx, arr.get(idy));
			arr.set(idy, temp);
		}
		int curr = 0;
		for (int i = arr.size() - 1; i >= 0; i--) {
			curr *= 10;
			curr += arr.get(i);
		}
		return curr;
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

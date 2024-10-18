package medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem2044 {

	public static boolean createNextGeneration(int b[]) {
		int i = b.length - 1;
		while (i >= 0 && b[i] != 0)
			i--;
		if (i < 0)
			return false;
		b[i] = 1;
		for (int j = i + 1; j < b.length; j++)
			b[j] = 0;
		return true;
	}

	public static void printList(int b[]) {
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}

	public static int countMaxOrSubsets(int[] nums) {
		var a = new int[nums.length];
		List<Integer> bws = new ArrayList<>();
		while (createNextGeneration(a)) {
//			printList(a);
			int bw = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 1) {
					bw = bw | nums[i];
				}
			}
//			System.out.println("bitwise: " + bw);
			bws.add(Integer.valueOf(bw));
		}
		if (bws.size() > 0) {
			int max = bws.get(0);
			for (int i = 1; i < bws.size(); i++) {
				if (max < bws.get(i))
					max = bws.get(i);
			}
			int count = 0;
			for (int i = 0; i < bws.size(); i++) {
				if (bws.get(i) == max)
					count++;
			}
			return count;
		}
		return 0;
	}

	public static void main(String[] args) {

//		var b = new int[3];
//		printList(b);
//		while (createNextGeneration(b)) {
//			printList(b);
//		}

		System.out.println(countMaxOrSubsets(new int[] { 3, 1 }));
		System.out.println(countMaxOrSubsets(new int[] { 2, 2, 2 }));
		System.out.println(countMaxOrSubsets(new int[] { 3, 2, 1, 5 }));
	}

}

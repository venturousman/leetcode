package medium;

public class Problem3335 {

//	for (int i = 0; i < 26; i++) {
//		System.out.println(i + ": " + count[i]);
//	}

	public static int lengthAfterTransformations(String s, int t) {
		long mod = (long)Math.pow(10, 9) + 7;
//		System.out.println(mod);
		long[] count = new long[26]; // 122 - 97

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
//			count[index] += 1;
		    count[index] = (count[index] + 1) % mod; // Apply mod when updating count
		}
		
//		long len = s.length();
		long len = s.length() % mod; // Apply mod here as well

		for (int i = 0; i < t; i++) {

			long z = count[25];
			// shift
			for (int j = 25; j > 0; j--)
//				count[j] = count[j - 1];
		        count[j] = count[j - 1] % mod;
			
			count[0] = z;
//			count[1] += z;
		    count[1] = (count[1] + z) % mod; // Apply mod to prevent overflow
			
			len = (len + z) % mod;
		}

		return (int)len;
	}

	public static void main(String[] args) {
		// Input: s = "abcyy", t = 2
		// Output: 7
		System.out.println(lengthAfterTransformations("abcyy", 2));

		// Input: s = "azbk", t = 1
		// Output: 5
		System.out.println(lengthAfterTransformations("azbk", 1));

		// Input: s = "jqktcurgdvlibczdsvnsg", t = 7517
		// expected: 79033769
		System.out.println(lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));

	}

}

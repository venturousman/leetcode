package medium;

public class Problem3133 {
	
	public static long minEnd(int n, int x) {
        long[] nums = new long[n];
        nums[0] = x;
        long accAnd = x;
        for (int i = 1; i < n; i++) {
            long num = nums[i - 1];
            int bitLength = Long.toBinaryString(num).length();
            long allBitsSetNumber = (1 << bitLength) - 1;
            // System.out.println(bitLength);
            if (allBitsSetNumber == num) {
                int k = bitLength + 1;
                allBitsSetNumber = (1 << k) - 1;
            }
            // System.out.println(allBitsSetNumber);
            // System.out.println("------");
            for (long j = num + 1; j <= allBitsSetNumber; j++) {
                if ((j & accAnd) == x) {
//                    System.out.println(j);
                    nums[i] = j;
                    accAnd = accAnd & j;
                    break;
                }
            }
            // System.out.println(Arrays.toString(nums));
        }
        // System.out.println(Arrays.toString(nums));
        return nums[n - 1];
    }

	public static void main(String[] args) {
//		System.out.println(minEnd(3, 4)); // 6
//		System.out.println(minEnd(2, 7)); // 15
//		System.out.println(minEnd(4, 1)); // 7
		System.out.println(minEnd(6715154, 7193485)); // 55012476815
	}

}

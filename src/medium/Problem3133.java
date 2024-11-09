package medium;

public class Problem3133 {
	
	public static long minEnd(int n, int x) {
        long[] nums = new long[n];
        nums[0] = x;
        long accAnd = x;
        for (int i = 1; i < n; i++) {
            long num = nums[i - 1];
            
            // Generate the next number within a reasonable range based on the highest bit.
            long allBitsSetNumber = (Long.highestOneBit(num) << 1) - 1;
//            System.out.println(Long.highestOneBit(num));
//            System.out.println(allBitsSetNumber);
//            System.out.println("------");
            long next = num + 1;

            // Find the smallest number greater than `num` that satisfies the condition
            while ((next & accAnd) != x) {
                next++;
                if (next > allBitsSetNumber) {
                    allBitsSetNumber = (Long.highestOneBit(allBitsSetNumber) << 1) - 1;
                }
            }
            
            nums[i] = next;
            accAnd &= next;
            
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

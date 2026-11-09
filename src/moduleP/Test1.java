package moduleP;


/**
 * Amazon IQ
 * DSA 1. Find missing number
 */
public class Test1 {

	public static void main(String[] args) {
		int nums[] = { 1, 2, 4, 5, 6, 0 };
		int n = nums.length;
		int expectedSum = n * (n + 1) / 2;
		int actualSum = 0;
		System.out.println("sum from formula :" + expectedSum);
		for (int a1 : nums) {
			actualSum = actualSum + a1;
		}
		int missingNumber = expectedSum - actualSum;
		System.out.println("missing number is: " + missingNumber);
	}

}

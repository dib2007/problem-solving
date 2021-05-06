public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-100000, -1, -1000}));
    }
}

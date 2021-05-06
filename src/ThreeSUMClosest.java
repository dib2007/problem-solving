import java.util.Arrays;

public class ThreeSUMClosest {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i=0;i<nums.length-1;i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j<k) {
                if(nums[j] + nums[k] + nums[i] == target) return target;
                if (Math.abs(target - (nums[i] + nums[j] + nums[k])) < min) {
                    min = Math.abs(target - (nums[i] + nums[j] + nums[k]));
                    minSum = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return minSum;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }
}

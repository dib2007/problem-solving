import java.util.Arrays;

public class RotatedSortedArrayMin {

    public static int findMin(int[] nums) {
        return findMinInternal(nums, 0, nums.length);
    }

    private static int findMinInternal(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int mid = start + (end-start)/2;
        if (mid-1<0 || (nums[0] <= nums[mid-1])) {
            if (mid+1>=nums.length || (nums[nums.length-1] >= nums[mid])) {
                return Math.min(nums[0], nums[mid]);
            } else {
                return findMinInternal(nums, mid+1, end);
            }
        } else {
            return findMinInternal(nums, start, mid-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,3,1}));
    }
}

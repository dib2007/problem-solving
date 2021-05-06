import java.util.Arrays;

public class FindRange {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

    public static int[] searchRange(int[] nums, int target) {
        int start = searchStart(nums, 0, nums.length-1, target);
        if (start == -1) return new int[]{-1, -1};
        return new int[]{start, searchEnd(nums, start, nums.length-1, target)};
    }

    public static int searchStart(int[] nums, int start, int end, int target) {
        if (start>end) return -1;
        int mid = start + (end - start)/2;
        if (nums[mid] == target && (mid==0 || nums[mid-1] < target)) {
            return mid;
        }
        if(target <= nums[mid]) return searchStart(nums, start, mid -1, target);
        return searchStart(nums, mid+1, end, target);
    }

    public static int searchEnd(int[] nums, int start, int end, int target) {
        if (start>end) return -1;
        int mid = start + (end - start)/2;
        if (nums[mid] == target && (mid == nums.length-1 || nums[mid+1] > target)) {
            return mid;
        }
        if(target<nums[mid]) return searchEnd(nums, start, mid -1, target);
        return searchEnd(nums, mid+1, end, target);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,5,7,7,7,8,10}, 7)));
    }

}

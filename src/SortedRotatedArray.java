public class SortedRotatedArray {

    public static boolean search(int[] nums, int target) {
        return rSearch(nums, 0, nums.length-1, target);
    }

    static boolean rSearch(int[] nums, int start, int end, int val) {
        if(start > end) return false;
        int mid = (start + end)/2;
        if(nums[mid] == val) return true;
        if(nums[start] == val) return true;
        if(nums[end] == val) return true;
        if (nums[mid] == nums[start] && nums[start] == nums[end]) {
            start++;
            end--;
            rSearch(nums, start, end, val);
        }
        if(nums[start] <= nums[mid]) {
            if(val < nums[mid] && val > nums[start]) return rSearch(nums, start, mid-1, val);
            else return rSearch(nums, mid+1, end,val);
        } else {
            if(val > nums[mid] && val < nums[end]) return rSearch(nums, mid+1, end, val);
            else return rSearch(nums, start, mid-1, val);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,1,1,1}, 3));
    }
}

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        return bSearch(0, nums.length-1, nums, target);
    }

    public static int bSearch(int left, int right, int[] nums, int target) {
        if(left > right) {
            if(right < 0) {
                return nums[left]>target?left:left+1;
            } else {
                return nums[right]>target?right:right+1;
            }
        }
        int mid = (left+right)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target) return bSearch(left, mid-1, nums, target);
        return bSearch(mid+1, right, nums, target);
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3}, 0));
    }
}

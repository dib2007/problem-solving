public class RotatedSortedArraySearch {

    public static int search(int[] nums, int target) {
        return searchInternal(nums, 0, nums.length-1, target);
    }

    private static int searchInternal(int[] nums, int start, int end, int target) {
        if (start > end) return -1;
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;

        if (mid-1>=start && nums[start] > nums[mid-1]) { //Pivot in left
            if(target > nums[mid] && target <= nums[end]) { //target can be in right
                return searchInternal(nums, mid+1, end, target); //Search right
            } else {
                return searchInternal(nums, start, mid-1, target); //Search left
            }
        } else if (mid-1>=start && target<= nums[mid-1] && target >= nums[start]) { //target can be in left
            return searchInternal(nums, start, mid-1, target); //Search left
        } else {
            return searchInternal(nums, mid+1, end, target); //Search right
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{5,1,3}, 5));
    }

}

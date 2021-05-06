import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = -1;
        List<Integer> queue = new ArrayList<>();
        queue.add(nums[len-1]);
        for (index = len-2; index >=0 ; index--) {
            if(nums[index] < nums[index+1]) {
                break;
            }
            queue.add(nums[index]);
        }
        int i = index+1;
        boolean exchanged = false;
        for (int item : queue) {
            if(index>=0 && nums[index]<item && !exchanged) {
                nums[i] = nums[index];
                nums[index] = item;
                exchanged = true;
            } else {
                nums[i] = item;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,4,1};
        nextPermutation(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}

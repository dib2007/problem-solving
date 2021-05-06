import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSUM {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-1;i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            int j=i+1;
            int k = nums.length -1;
            while (j<k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    while(j<k && nums[j] == nums[j-1]) j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }
}

//-1,0,1,2,-1,-4

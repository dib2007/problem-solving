import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumSubarraysWithSum {

    public static int numSubarraysWithSum(int[] A, int S) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int i=0;i<A.length;i++) {
            sum += A[i];
            if (sumMap.get(sum - S) != null) {
                count += sumMap.get(sum-S);
            }
            if(sum == S) count++;
            sumMap.putIfAbsent(sum, 0);
            sumMap.put(sum, sumMap.get(sum) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}


//s2 - s1 = S
//s1 = s2 - S
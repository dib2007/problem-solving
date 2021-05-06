import java.util.*;
import java.util.stream.Collectors;

public class ThirdMaxNumber {
    public static int thirdMax(int[] nums) {
        int k=3;
        Queue<Integer> heap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        for (int i : list) {
            if (heap.size() < k) {
                heap.add(i);
            } else if (i > heap.peek()) {
                heap.remove();
                heap.add(i);
            }
        }
        if (heap.size() < k) {
            int result = -1;
            while (!heap.isEmpty()) {
                result = heap.remove();
            }
            return result;
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{1,2}));
    }
}

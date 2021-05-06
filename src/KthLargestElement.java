import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int i : nums) {
            if (heap.size() < k) {
              heap.add(i);
            } else if (i > heap.peek()) {
                heap.remove();
                heap.add(i);
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}

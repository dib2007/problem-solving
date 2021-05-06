import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fMap = new HashMap<>();
        for(int i : nums) fMap.put(i, fMap.getOrDefault(i,0)+1);
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> fMap.get(o1) - fMap.get(o2));
        for (int i : fMap.keySet()) {
            heap.add(i);
            if(heap.size() > k) heap.poll();
        }
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{5,2,5,3,5,3,1,1,3}, 2)));

    }
}
//[5,2,5,3,5,3,1,1,3]
//        2
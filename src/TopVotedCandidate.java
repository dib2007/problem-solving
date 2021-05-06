import java.util.*;

public class TopVotedCandidate {
    int[] times;
    int[] max;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.max = new int[times.length];
        int maxCount = Integer.MIN_VALUE;
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxP = 0;
        for(int i=0;i<times.length;i++) {
            countMap.putIfAbsent(persons[i], 0);
            countMap.put(persons[i], countMap.get(persons[i]) + 1);
            if(countMap.get(persons[i]) >= maxCount) {
                maxP = persons[i];
                maxCount = countMap.get(persons[i]);
            }
            this.max[i] = maxP;
        }
        Arrays.stream(this.max).forEach(System.out::print);
        this.times = times;
    }

    public int q(int t) {
        int index = Arrays.binarySearch(this.times, t);
        if (index < 0) index = -index-2;
        System.out.println(index);
        return this.max[index];
    }

    static int search(List<Integer> keyList, int t) {
        int low = 0;
        int high = keyList.size() - 1;
        int mid = (low + high)/2;
        while(low <= high) {
            mid = (low + high)/2;
            if(keyList.get(mid) == t) {
                return t;
            }
            if(t > keyList.get(mid)) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return (t > keyList.get(mid))?keyList.get(mid):keyList.get(mid-1);
    }

    public static void main(String[] args) {
       // System.out.println(Arrays.binarySearch(new int[]{1,3,5,6,7,9}, 2));
        TopVotedCandidate obj = new TopVotedCandidate(new int[]{0,0,1,1,2}, new int[]{0,67,69,74,87});
        System.out.println(obj.q(100));
    }
}

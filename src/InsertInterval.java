import java.util.*;

public class InsertInterval {

    //https://leetcode.com/problems/insert-interval/

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Set<Integer[]> result = new TreeSet<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[1];
            }
        });
        int min = newInterval[0];
        int max = newInterval[1];
        for (int[] interval : intervals) {
            if ((newInterval[0] >= interval[0] && newInterval[0] <= interval[1]) || interval[0] >= newInterval[0] && interval[0] <= newInterval[1]) {
                min = Math.min(interval[0], min);
                max = Math.max(interval[1], max);
            } else {
                result.add(new Integer[]{interval[0], interval[1]});
            }
        }
        if(min != -1) {
            result.add(new Integer[]{min, max});
        }
        int[][] resultArr = new int[result.size()][2];
        int i=0;
        for (Integer[] r : result) {
            resultArr[i][0] = r[0];
            resultArr[i][1] = r[1];
            i++;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
    }
}

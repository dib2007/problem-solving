import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

    //https://leetcode.com/problems/merge-intervals/

    public static int[][] merge(int[][] intervals) {
        Stack<Integer[]> stack = new Stack<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(new Integer[]{interval[0], interval[1]});
            } else {
                int start = interval[0];
                int end = interval[1];
                while (!stack.isEmpty()) {
                    Integer[] top = stack.peek();
                    if ((interval[0] >= top[0] && interval[0] <= top[1]) || (top[0] >= interval[0] && top[0] <= interval[1])) {
                        start = Math.min(interval[0], top[0]);
                        end = Math.max(interval[1], top[1]);
                        stack.pop();
                    } else {
                        break;
                    }
                }
                stack.push(new Integer[]{start, end});
            }
        }
        int[][] result = new int[stack.size()][2];
        int i=0;
        while (!stack.isEmpty()) {
            Integer[] top = stack.pop();
            result[i][0] = top[0];
            result[i][1] = top[1];
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}})));
    }
}

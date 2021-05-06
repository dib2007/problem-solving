import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoint {

        public static int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    double d = ((Math.pow((Math.pow(o2[0], 2) + Math.pow(o2[1], 2)), .5)) - (Math.pow((Math.pow(o1[0], 2) + Math.pow(o1[1], 2)), .5)));
                    return d==0?0:d>0?1:-1;
                }
            });

            for (int[] point : points) {
                heap.add(point);
                if (heap.size() > k) heap.poll();
            }
            int[][] result = new int[k][2];
            int i = 0;
            while (!heap.isEmpty()) {
                result[i++] = heap.poll();
            }
            return result;
        }

        public static void main(String[] args) {
            int[][] arr = kClosest(new int[][]{{-5,4},{-6,-5},{4,6}}, 2);
            for (int[] ints : arr) {
                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print("[");
                    System.out.print(ints[j]);
                    System.out.print("]");
                }
                System.out.print("\n");
            }
        }
    }


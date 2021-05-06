public class Partition {

    public static int partitionDisjoint(int[] A) {
        int[] lMax = new int[A.length];
        int[] rMax = new int[A.length];
        int[] rMin = new int[A.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i=A.length-1;i>=0;i--) {
            rMax[i] = max;
            rMin[i] = min;
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }
        max = Integer.MIN_VALUE;
        for (int i=0;i<A.length;i++) {
            max = Math.max(A[i], max);
            lMax[i] = max;
            if(rMax[i] >= lMax[i] && lMax[i] <= rMin[i]) {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{1,1,1,0,6,12}));
    }
}

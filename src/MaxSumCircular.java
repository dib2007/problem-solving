public class MaxSumCircular {
    public static int maxSubarraySumCircular1(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int i=0;
        int[] sumArr = new int[A.length];
        sumArr[0] = A[0];
        for(int k=1;k<A.length;k++) {
            sumArr[k] = A[k-1] + A[k];
        }
        while(i<A.length) {
            int sum = 0;
            int j =0;
            while(j<A.length) {
                sum += A[(i+j)%A.length];
                if(sum > maxSum) {
                    maxSum = sum;
                }
                if(sum <= 0) {
                    i = i+j;
                    break;
                }
                j++;
            }
            i++;
        }
        return maxSum;
    }

    public static int maxSubarraySumCircular(int[] A) {
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int tempSumMin = 0;
        int tempSumMax = 0;
        int totalSum = 0;
        for(int x : A) {
            tempSumMax += x;
            tempSumMin += x;
            if(tempSumMax<0) tempSumMax = 0;
            if(tempSumMin>0) tempSumMin = 0;
            if(tempSumMax>maxSum) maxSum = tempSumMax;
            if(tempSumMin<minSum) minSum = tempSumMin;
            if(x>max) max = x;
            totalSum += x;
        }
        if(max<0) return max;
        return Math.max(maxSum, totalSum-minSum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }
}

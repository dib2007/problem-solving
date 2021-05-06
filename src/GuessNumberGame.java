import java.util.Arrays;

public class GuessNumberGame {

    public static int getMoneyAmount(int n) {
        int min = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++) {
            int leftMax = max(1,i-1) + i;
            int rightMax = max(i+1,n) + i;
            System.out.printf("Index: %d LeftMax: %d RightMax: %d\n",i,leftMax, rightMax);
            if (Math.max(leftMax, rightMax) < min) {
                min = Math.max(leftMax, rightMax);
            }
        }
        return min;
    }

    static int max(int left, int right) {
        int sum = 0;
        while(left< right) {
            int mid = left + (right - left)/2;
            sum+=mid;
            left = mid+1;
        }
        return sum;
    }

    public static int getMoneyAmount1(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int d=1; d<n; d++){
            for(int i=1; i+d<=n; i++){
                int j=i+d;
                if(d == 1)
                    dp[i][j] = i;
                else{
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=i+1; k<j; k++)
                        dp[i][j]=Math.min(dp[i][j], k+Math.max(dp[k+1][j], dp[i][k-1]));
                }
            }
        }
        return dp[1][n];
    }

    public static int getMoneyAmount2(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int[] row: dp)
            Arrays.fill(row, -1);
        min(1, n, dp);
        return dp[1][n];
    }

    public static int min(int start, int end, int[][] dp) {
        if(dp[start][end] != -1) return dp[start][end];
        if(end - start == 1) {
            dp[start][end] = start;
            return dp[start][end];
        } else if(end == start) {
            dp[start][end] = 0;
            return dp[start][end];
        }
        int val = Integer.MAX_VALUE;
        for(int k=start+1;k<end;k++) {
            val = Math.min(val, k + Math.max(min(start, k-1, dp), min(k+1, end, dp)));
        }
        dp[start][end] = val;
        return dp[start][end];
    }


    public static void main(String[] args) {
        System.out.println(getMoneyAmount2(10));
    }
}

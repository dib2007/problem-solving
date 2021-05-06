public class NoOfUniquePaths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        getPath(0, 0, m ,n, dp);
        return dp[0][0];
    }

    static int getPath1(int row, int col, int m, int n, int[][] dp, int[][] og) {
        if(dp[row][col] != 0) return dp[row][col];
        if(row < m-1 && og[row+1][col] == 0) dp[row][col] = getPath1(row + 1, col, m, n, dp, og);
        if(col < n-1 && og[row][col+1] == 0) dp[row][col] += getPath1(row, col+1, m, n, dp, og);
        return dp[row][col];
    }

    public static int uniquePaths1(int[][] og) {
        int m = og.length;
        int n = og[0].length;
        if(og[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;
        getPath1(0, 0, m ,n, dp, og);
        return dp[0][0];
    }

    static int getPath(int row, int col, int m, int n, int[][] dp) {
        if(dp[row][col] != 0) return dp[row][col];
        if(row < m-1) dp[row][col] = getPath(row + 1, col, m, n, dp);
        if(col < n-1) dp[row][col] += getPath(row, col+1, m, n, dp);
        return dp[row][col];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths1(new int[][]{{0,1},{0,0}}));
    }

}

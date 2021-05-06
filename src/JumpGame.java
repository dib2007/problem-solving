public class JumpGame {
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[len-1] = true;
        for (int i=len-2;i>=0;i--) {
            for(int j=i+1;j<=i+nums[i];j++) {
                if(j>=len-1 || dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}

//[3,2,1,0,4]

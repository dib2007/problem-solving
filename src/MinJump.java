public class MinJump {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,0,1,4}));
    }

    public static int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        for (int i=1;i<nums.length;i++) {
            jumps[i] = Integer.MAX_VALUE;
        }
        for (int i=1;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if(j + nums[j] >= i) {
                    if(jumps[i] > jumps[j] + 1) {
                        jumps[i] = jumps[j] + 1;
                    }
                }
            }
        }
        return jumps[nums.length-1];
    }
}

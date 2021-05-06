public class MinimumFlipToMonotonicIncrement {
    public static int minFlipsMonoIncr(String S) {
        int length = S.length();

        int[] p = new int[length+1];
        for(int i=0;i<length;i++) {
            p[i+1] = p[i] + (S.charAt(i) == '1'?1:0);
        }
        int flip = Integer.MAX_VALUE;
        for (int i =0;i<=length;i++) {
            flip = Math.min(flip, p[i] + ((length - i) - (p[length] - p[i])));
        }
        return flip;
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00011000"));
    }
}

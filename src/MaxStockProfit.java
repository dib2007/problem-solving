import java.util.Arrays;

public class MaxStockProfit {

    public static int maxProfit(int[] prices) {
        int[] maxArr = new int[prices.length];
        int maxVal = Integer.MIN_VALUE;
        for(int i=prices.length-1;i>=0;i--) {
            if (prices[i] > maxVal) maxVal = prices[i];
            maxArr[i] = maxVal;
        }
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++) {
            if (maxArr[i] -prices[i]> maxProfit) maxProfit = maxArr[i] - prices[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SumSubArrayMins {

    public static int sumSubarrayMins(int[] arr) {
        int[] dp = new int[arr.length];
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            dp[i] = arr[i];
            sum+=arr[i];
        }
        for(int i=0;i<arr.length;i++) {
            for (int j=1;i+j<arr.length;j++) {
                dp[i] = Math.min(dp[i], arr[i + j]);
                sum+=dp[i];
                sum%=1000000007;
            }
        }
        return sum;
    }

    public static int sumSubArrayMin1(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int topIndex = stack.pop();
                //sum += (arr[topIndex] * (i - topIndex - 1));
                if(!stack.isEmpty()) {
                    int nextTop = stack.peek();
                    sum += (arr[topIndex] * (i - topIndex - 1) * (topIndex - nextTop));
                } else {
                    sum += (arr[topIndex] * (i - topIndex - 1) * (topIndex + 1));
                }
            }
            if(stack.isEmpty()) {
                sum += (arr[i] * (i+1));
            } else {
                sum += (arr[i] * (i - stack.peek()));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            if(!stack.isEmpty()) {
                int nextTop = stack.peek();
                sum += (arr[topIndex] * (arr.length - topIndex - 1) * (topIndex - nextTop));
            } else {
                sum += (arr[topIndex] * (arr.length - topIndex - 1) * (topIndex + 1));
            }
        }
        return (int)(sum%1000000007);
    }

    public static int brute(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++) {
            for(int j=0;i+j<arr.length;j++) {
                int min = 0;
                for(int k=i;k<=i+j;k++) {
                    System.out.print(arr[k] + "_");
                    min = Math.min(min, arr[k]);
                }
                System.out.println("");
                map.putIfAbsent(arr[i], 0);
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        System.out.println(map);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumSubArrayMin1(new int[]{60,39,58,30}));
        System.out.println(brute(new int[]{11,81,94,43,3}));
    }
}

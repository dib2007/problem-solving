import java.util.Arrays;

public class SmallestRange {

    public static int smallestRangeII(int[] arr, int k) {
        {
            // Find max and min elements of the array
            int max = Arrays.stream(arr).max().getAsInt();
            int min = Arrays.stream(arr).min().getAsInt();

            // Check whether the difference between
            // the max and min element is less than
            // or equal to k or not
            if ((max - min) <= k)
            {
                return (max - min);
            }

            // Calculate average of max and min
            int avg = (max + min) / 2;

            for (int i = 0; i < arr.length; i++)
            {
                // If the array element is greater than the
                // average then decrease it by k
                if (arr[i] > avg)
                {
                    arr[i] -= k;
                }

                // If the array element is smaller than the
                // average then increase it by k
                else
                {
                    arr[i] += k;
                }
            }

            // Find max and min of the modified array
            max = Arrays.stream(arr).max().getAsInt();
            min = Arrays.stream(arr).min().getAsInt();

            // return the new difference
            return (max - min);
        }
    }

    public static void main(String[] args) {
        System.out.println(smallestRangeII(new int[]{3,4,7,0}, 5));
    }

}

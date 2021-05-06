import java.util.ArrayList;
import java.util.List;

public class KClosest {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int pos = -1;
        while(left<right) {
            int mid = left + (right - left)/2;
            if (arr[mid] == x) {
                pos = mid;
                break;
            } else if(x < arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (pos == -1) {
            left = right -1;
        } else {
            left = pos -1;
            right = pos;
        }
        // Check k nearest now
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<k;i++) {
            if(left >=0) {
                if (right >= arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                    result.add(arr[left]);
                    left--;
                } else {
                    result.add(arr[right]);
                    right++;
                }
            } else if (right<arr.length) {
                result.add(arr[right]);
                right++;
            }
            else break;
        }
        result.sort(Integer::compareTo);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, -1));
    }
}

//public class MedianOfTwoSortedArrays {
//
//    //https://leetcode.com/problems/median-of-two-sorted-arrays/
//
//    public double findMedianSortedArrays(int[] a, int[] b) {
//        return a.length>=b.length?median(a, b, 0, a.length-1):median(b, a, 0, b.length-1);
//    }
//
//    double median(int[] a, int[] b, int start, int end) {
//        int mid1 = start + (end-start)/2;
//        int mid2 = (b.length -1)/2 + ((a.length-1)/2 - mid1)/2;
//
//        if(a[mid1-1] <= b[mid2+1] && b[mid2-1] <= a[mid1+1]) {
//            if((a.length+b.length)%2 !=0) return b[mid2];
//            else return (a[mid1] + b[mid2])/2.0;
//        } else if ()
//
//    }
//
//}
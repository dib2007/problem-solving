public class MinOfSortedArrays {

    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int start = 0;
        int end = nums1.length-1;
        int mid = (start + end)/2;
        while (mid<nums1.length) {
            int midy = getOtherMid(mid, nums1.length, nums2.length);
            if(mid == 0 ||midy == nums2.length -1) {

            } else if(midy == 0 ||  mid == nums1.length-1) {

            }
            mid = (start + end)/2;
        }
        return 0;
    }

    public static int getMedian(int[] nums1, int[] nums2, int mid) {
        if (mid == 0) {
            if((nums1.length + nums2.length)%2 ==0) {

            } else {

            }
        } else if (mid == nums1.length-1) {

        }
        return 0;
    }

    public static int getOtherMid(int mid, int x, int y) {
//        return (x+y)/2-2-mid;
//        Math.m
        return 0;
    }


}

public class WaterBetweenTwoBuildings {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxWater = 0;
        while(i<j) {
            maxWater = Math.max(maxWater, (j-1) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxWater;
    }
}

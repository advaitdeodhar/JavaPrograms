package LeetCode150;

class ContainerWithMostWater {
    public int maxArea(int[] height) {

        int i = 0 ;
        int j = height.length - 1;
        int area = Integer.MIN_VALUE;
        int current;
        int h;
        while ( i < j ) {

            h = Math.min(height[i], height[j]);
            current = h * ( j - i );

            if ( current > area ) {
                area = current;
            }

            if ( height[i] < height[j] ) {
                i++;
            } else {
                j--;
            }
        }

        return area;

    }
}
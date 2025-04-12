import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public int trap(int[] height) {

//        Set<Integer> levels = new TreeSet<>();
//
//        for ( Integer i : height ) {
//            levels.add(i);
//        }
//        int start = 0 ;
//
//        int ans = 0;
//        int lastLevel = 0;
//        for ( Integer level : levels ) {
//            if ( level == 0 ) {
//                continue;
//            }
//            boolean started = false;
//            for (int i = 0; i < height.length; i++) {
//                if (height[i] >= level ) {
//                    if ( started ) {
//                        ans += ( i - start - 1) * ( level - lastLevel );
//                        start = i;
//                        continue;
//                    }
//                    start = i;
//                    started = true;
//                }
//            }
//            lastLevel = level;
//        }
//
//        return ans;


        int l = 1;
        int r = height.length - 2;

        int lmax = height[0];
        int rmax = height[height.length -1];
        int ans = 0;

        while ( l <= r ) {
            if ( lmax < rmax ) {
                ans += Math.max(0, lmax - height[l]);
                lmax = Math.max(lmax, height[l]);
                l++;
            } else {
                ans += Math.max(0, rmax - height[r]);
                rmax = Math.max(rmax, height[r]);
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] data = {2,0, 0, 1};

        Solution s = new Solution();
        System.out.println(s.trap(data));
    }
}
package LeetCode150.Hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(nums[0], 0);
        int remaining;
        for ( int i = 1 ; i < nums.length; i++ ) {
            remaining = target - nums[i];
            if ( map.containsKey(remaining) ) {
                return new int[]{map.get(remaining), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum s = new TwoSum();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}

package LeetCode150.Hashmap;

import java.util.HashMap;

class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> cache = new HashMap<>();
        int c;
        Integer pI;

        for (int i = 0 ; i < nums.length; i++ ) {

            c = nums[i];


            pI = cache.get(c);

            if ( pI != null ) {
                if ((i - pI) <= k) {
                    return true;
                }
            }

            cache.put(c, i);

        }
        return false;

    }

}

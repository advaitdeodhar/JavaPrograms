package LeetCode150.Hashmap;

import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        List<List<Integer>> retVal = new ArrayList<>();

        Map<Integer, Integer> ranges = new HashMap<>();
        BitSet b = new BitSet();

        for ( int i = 0 ; i < points.length; i++ ) {
            b.set(points[i][0]);
            ranges.put(points[i][0], Math.max(points[i][1], ranges.getOrDefault(points[i][0], -1)));
        }


        int start = b.nextSetBit(0);
        int end = ranges.get(start);
        int nextStart = start;

        while( true ) {

            nextStart = b.nextSetBit(nextStart + 1);

            if ( nextStart == -1) {
                break;
            }

            if ( end >= nextStart ) {
                end = Math.max(ranges.get(nextStart), end);
            } else {
                List<Integer> range = new ArrayList<>();

                range.add(start);
                range.add(end);

                retVal.add(range);

                start = b.nextSetBit(end + 1);

                if ( start == -1) {
                    break;
                }

                end = ranges.get(start);
                nextStart = start;

            }

        }

        List<Integer> range = new ArrayList<>();

        range.add(start);
        range.add(end);

        retVal.add(range);

        int[][] ans = new int[retVal.size()][2];

        for ( int i = 0; i < retVal.size(); i++ ) {
            ans[i][0] = retVal.get(i).get(0);
            ans[i][1] = retVal.get(i).get(1);

        }

        return ans.length;

    }
}

package LeetCode150.Hashmap;

import java.util.*;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> retVal = new ArrayList<>();

        Map<Integer, Integer> ranges = new HashMap<>();
        BitSet b = new BitSet();

        for ( int i = 0 ; i < intervals.length; i++ ) {
            b.set(intervals[i][0]);
            ranges.put(intervals[i][0], Math.max(intervals[i][1], ranges.getOrDefault(intervals[i][0], -1)));
        }

        b.set(newInterval[0]);
        ranges.put(newInterval[0], Math.max(newInterval[1], ranges.getOrDefault(newInterval[0], -1)));


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

        return ans;


    }
}

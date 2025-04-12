package LeetCode150.Hashmap;

import java.util.*;

class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> retVal = new ArrayList<>();

        Map<Integer, Integer> ranges = new HashMap<>();
        BitSet b = new BitSet();

        for ( int i = 0 ; i < intervals.length; i++ ) {
            b.set(intervals[i][0]);
            ranges.put(intervals[i][0], Math.max(intervals[i][1], ranges.getOrDefault(intervals[i][0], -1)));
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

        return ans;


    }

    public static void main(String[] args) {
        MergeIntervals s = new MergeIntervals();
        System.out.println(Arrays.deepToString(s.merge(new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}})));
    }
}

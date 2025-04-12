package LeetCode150.Hashmap;

import java.util.ArrayList;
import java.util.List;

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        List<String> retVal = new ArrayList<>();

        if ( nums.length == 0 ) {
            return retVal;
        }
        int start;

        start = nums[0];
        int current = nums[0];
        for ( int i = 1; i < nums.length; i++) {

            if ( nums[i] == current + 1) {
                current++;
                continue;
            }

            retVal.add((current - start ) == 0 ? start + "" : start + "->" +current);
            start = nums[i];
            current = start;


        }

        retVal.add((current - start ) == 0 ? start + "" : start + "->" +current);

        return retVal;

    }

    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();

        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}

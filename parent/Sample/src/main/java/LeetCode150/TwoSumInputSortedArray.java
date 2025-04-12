package LeetCode150;

class TwoSumInputSortedArray {
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];

        int i = 0 ;
        int j = numbers.length - 1;

        int sum ;
        while ( i < j ) {
            sum = numbers[i] + numbers[j];

            if ( sum < target) {
                i++;
                continue;
            }

            if ( sum > target ) {
                j--;
                continue;
            }

            ans[0] = i + 1;
            ans[1] = j + 1;
            return ans;

        }

        return ans;
     }
}
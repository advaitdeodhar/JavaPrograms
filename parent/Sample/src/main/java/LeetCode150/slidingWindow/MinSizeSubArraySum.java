package LeetCode150.slidingWindow;

class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {

        int ans = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;

        int sum = 0;

        int current;

        sum += nums[right];
        while(true) {
            if ( sum < target ) {
                right++;
                if ( right == nums.length) {
                    break;
                }
                sum += nums[right];
                continue;
            }
            current = right - left + 1;
            if ( current < ans ) {
                ans = current;
            }
            sum -= nums[left];
            left++;

        }

        return ans == Integer.MAX_VALUE ? 0 : ans;

    }

    public static void main(String[] args) {
        MinSizeSubArraySum s = new MinSizeSubArraySum();
        System.out.println(s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}

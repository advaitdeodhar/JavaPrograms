package LeetCode150;

import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();

        TreeMap<Integer, ArrayList<Integer>> one = new TreeMap<>();

        for ( int i = 0 ; i < nums.length; i++  ) {
            ArrayList<Integer> indices = one.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            one.put(nums[i], indices);
        }

        int twoSum;
        for ( int i = 0 ; i < nums.length - 2; i++ ) {
            for ( int j = i + 1; j < nums.length - 1; j++ ) {
                twoSum = nums[i] + nums[j];

                ArrayList<Integer> indices = one.get(-twoSum);

                if ( indices != null ) {
                    addAns( nums, ans, i , j, indices);
                }
            }
        }

        return ans.stream().toList();
        //return ans;

    }

    private void addAns(int[] nums, Set<List<Integer>> ans, int i, int j, ArrayList<Integer> indices) {

        for ( Integer index : indices ) {
            if ( index != i && index != j ) {
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[index]);
                Collections.sort(l);
                ans.add(l);
                return;
            }
        }

    }

    public static void main(String[] args) {

        ThreeSum s = new ThreeSum();

        System.out.println(s.threeSum(new int[]{0,0,0}));
    }


}

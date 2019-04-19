package top100;

public class MaximumSubarray_53 {
    //Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    class Solution {
        public int maxSubArray(int[] nums) {
            int curSum = nums[0];
            int max = curSum;
            for (int i = 1; i < nums.length; i++) {
                curSum = Math.max(nums[i], curSum+nums[i]);
                max = Math.max(curSum, max);
            }
            return max;
        }

        public int maxSubArray1(int[] nums) {
            int curSum = nums[0];
            int max = curSum;
            for (int i = 1; i < nums.length; i++) {
                if (curSum < 0)
                    curSum = nums[i];
                else
                    curSum += nums[i];
                if (curSum > max)
                    max = curSum;
            }
            return max;
        }
    }
}

package top100;

import java.util.Arrays;

public class HouseRobber_198 {

    class Solution {
        private int[] mem;

        public int rob(int[] nums) {
            if (nums.length <= 0)
                return 0;
            mem = new int[nums.length];
            Arrays.fill(mem, -1);
            return robHelp(nums, nums.length-1);
        }

        private int robHelp(int[] nums, int i) {
            if (i < 0)
                return 0;
            if (mem[i] != 0) {
                return mem[i];
            }
            mem[i] = Math.max(robHelp(nums, i-2) + nums[i], robHelp(nums, i-1));
            return mem[i];
        }
    }

    class Solution1 {
        private int[] mem;

        public int rob(int[] nums) {
            if (nums.length <= 0)
                return 0;

            // mem[i] 记录[0, i]个房子的最大值
            mem = new int[nums.length+1];
            mem[0] = 0;
            mem[1] = nums[0];
            for (int i = 2; i < nums.length; i++) {
                mem[i] = Math.max(mem[i-1], mem[i-2] + nums[i]);
            }

            return mem[nums.length+1];
        }


    }
}

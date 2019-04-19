import java.util.Arrays;

public class MoveZeros_283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }


    static class Solution {
        public static void moveZeroes(int[] nums) {
            int i = 0, j = 0;       //[0...i)非0区间
            while(j < nums.length) {
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
            while(i < nums.length) {
                nums[i] = 0;
                i++;
            }

        }
    }
}

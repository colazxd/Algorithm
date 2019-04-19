
/**
 * 给定n个元素的数组，数组中只包含0，1，2三种可能，为这个数组排序
 */
public class SortColors_75 {

    static class Solution {
        public void sortColors(int[] nums) throws Exception {
            int[] count = new int[3];
            for (int i = 0; i < nums.length; i++) {
                switch (nums[i]) {
                    case 0: count[0]++; break;
                    case 1: count[1]++; break;
                    case 2: count[2]++; break;
                    default: throw new Exception("invalid items");
                }
            }
            int index = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k<count[j]; k++) {
                    nums[index++] = j;
                }
            }
        }

        public void sortColors2(int[] nums) {
            // [0...zero]==0
            // [zero+1...i-1]==1
            // [two...nums.length-1]==2
            int zero = -1, two = nums.length;
            for (int i = 0; i < two; ) {
                if (nums[i] == 1) {
                    i++;
                } else if (nums[i] == 2) {
                    two--;
                    swap(nums, i, two);
                } else {
                    assert nums[i] == 0;
                    zero++;     //zero+1为1
                    swap(nums, i, zero);
                    i++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

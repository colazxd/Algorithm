public class RemoveDuplicatesfromSortedArray_26 {

    static class Solution {
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length==0) {
                return 0;
            }
            if (nums.length == 1) {     //只有一个元素
                return 1;
            }
            int distinct_index = 0;
            int distinct_count = 1;
            for (int i = 1; i < nums.length; i++) { //有两个以上
                if(nums[i] == nums[distinct_index]) {
                    continue;
                } else {
                    distinct_count++;
                    distinct_index++;
                    swap(nums, i, distinct_index);
                }
            }
            return distinct_count;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
}

public class RemoveDuplicatesfromSortedArray2_80 {
    /**
     * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int len = Solution.removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i<len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static class Solution {
        public static int removeDuplicates(int[] nums) {
            if(nums == null || nums.length==0) {
                return 0;
            }
            //[0...k]保存满足最多重复两次的元素
            int k = 0;
            boolean flag=false;//标记是否第三次次出现，第一次false，第二次true， 相等且为true说明是第三次出现
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[k]) {
                    flag=false; //第一次出现，flag置为false
                    ++k;
                    if (k != i) {
                        nums[k] = nums[i];    //直接赋值行不行?
                    }
                } else {
                    if (flag==false) {  //第二次出现也要移进[0...k]
                        flag=true;
                        nums[++k] = nums[i];
                    }
                }
            }
            return k+1;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

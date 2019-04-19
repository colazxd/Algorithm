import java.util.Random;

public class KthLargestElementInArray_215 {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        int k = 2;
        int result = Solution.findKthLargest(nums, k);
        System.out.println(result);

    }

    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            int l = 0, h = nums.length - 1;
            while(l < h) {
                int large_index = partation(nums, l, h);    //每次partation完，large_index位于排序好的位置
                if (large_index == k-1) {
                    break;
                } else if (large_index > k-1) {
                    h = large_index-1;
                } else {
                    l = large_index+1;
                }
            }
            return nums[k-1];
        }

        private static int partation(int[] nums, int start, int end) {
            int key_index = new Random().nextInt(end-start) + start;
            swap(nums, key_index, end);

            int large_index = start-1;  //指向large部分的最后元素
            for(int i=start; i<end; i++) {
                if(nums[i] > nums[end]) {
                    ++large_index;      //small的第一个
                    if(large_index != i)
                        swap(nums, large_index, i);
                }

            }
            ++large_index;
            swap(nums, large_index, end);
            return large_index;
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}

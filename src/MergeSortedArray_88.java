import java.util.Arrays;

/**
 * 归并两个有序数组nums1 和 nums2,各自包含元素个数为m和n
 * 其中nums1的数组大小>=（m+n）
 */
public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;

        MergeSortedArray_88.Solution.merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }




    static class Solution {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            //借助辅助数组union，从头到尾依次比较，合并到union中
            int[] union = new int[m+n];
            int i=0, j=0, k=0;
            while(i<m && j<n) {
                if (nums1[i] <= nums2[j]) {
                    union[k] = nums1[i++];
                } else {
                    union[k] = nums2[j++];
                }
                k++;
            }
            while(i<m) {
                union[k++] = nums1[i++];
            }
            while(j<n) {
                union[k++] = nums2[j++];
            }
            for (int x=0; x<(m+n); x++) {
                nums1[x] = union[x];
            }
        }

        public static void merge2(int[] nums1, int m, int[] nums2, int n) {
            //直接在nums1上归并，从尾到头归并以避免覆盖问题
            if (m==0) {
                for (int i=0; i<n; i++){
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (n==0)
                return;

            int index1 = m-1;
            int index2 = n-1;
            int union_index = m+n-1;
            while (index1 >=0 && index2 >=0) {
                if (nums1[index1] > nums2[index2]) {
                    nums1[union_index] = nums1[index1--];
                } else {
                    nums1[union_index] = nums2[index2--];
                }
                union_index--;
            }
            while(index1 >=0) {
                nums1[union_index--] = nums1[index1--];
            }
            while(index2 >=0) {
                nums1[union_index--] = nums2[index2--];
            }


        }
    }
}

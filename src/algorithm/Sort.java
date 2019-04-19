package algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Sort {

    /**
     * 选择排序
     * 注意交换次数，比较后可以先记录minindex下标，一轮比较结束换一次最小值，不要每次比较完就换
     * @param nums
     */
    public void selection(int[] nums) {
        int N = nums.length;
        for(int i=0; i<N-1; i++) {
            int minIndex = i;
            for (int j = i+1; j<N; j++) {
                if(nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
    }

    /**
     * 实现冒泡，大的向后冒
     * 两层循环分别从左右
     * @param nums
     */
    public void bubbleSort(int[] nums) {
        boolean isSorted = false;
        int N = nums.length;
        for (int i=N-1; i>0 && !isSorted; i--) {
            isSorted = true;
            for (int j=0; j<i; j++) {
                if (nums[j] > nums[j+1]) {
                    isSorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序，小的往前冒
     * @param nums
     */
    public void bubbleSort1(int[] nums) {
        boolean isSorted = false;
        for (int i = 0; i < nums.length && !isSorted; i++) {
            isSorted = true;
            for (int j = nums.length-1; j > i; j--) {
                if (nums[j] < nums[j-1]) {
                    isSorted = false;
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
    }

    /**
     * &&表达式条件顺序，先检查下表，再取数组元素比较大小！
     * 插入排序交换次数等于逆序数
     * @param nums
     */
    public void insertSort(int[] nums) {
        for(int i = 1; i<nums.length; i++) {
            int j=i;
            while( j > 0  && nums[j] < nums[j-1]) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
    }


    /**
     * 希尔排序， 等于多次进行插入排序，
     * 外部多一层while 控制间隔变量，由大到小，每次缩小到1/3，直到缩小为1，为一次插入排序
     * @param nums
     */
    public void shellSort(int[] nums) {
        int N = nums.length;
        //确定间隔长度
        int h = 1;
        while(h < N/3)
            h = 3*h + 1;  //1  4  7

        while(h > 0) {
            for (int i = h; i < N; i+=h) {
                for (int j = i; j >=h && nums[j] < nums[j-h]; j-=h) {
                    int temp = nums[j];
                    nums[j] = nums[j-h];
                    nums[j-h] = temp;
                }
            }
            h = h / 3;
        }
    }

    /**
     * 归并排序，自顶向下采用递归
     * @param nums
     * @param start
     * @param end
     */
    public void mergeSort(int[] nums, int start, int end) {
//        if (end <= start)
//            return;
        int mid = (end - start)/2 + start;
        if (start < end) {
            mergeSort(nums, start, mid);
            mergeSort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }

    }

    private void merge(int[] nums, int left, int mid, int right) {
        //归并[left, mid] 和 [mid+1, right]


        int[] temp = new int[right-left+1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + left] = temp[k2];
        }
    }

    public static void merge2(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + low] = temp[k2];
        }
    }

    public static void mergeSort2(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            mergeSort2(a, low, mid);
            // 右边
            mergeSort2(a, mid + 1, high);
            // 左右归并
            merge2(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }

    }



    static class QuickSort {

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private int partition(int[] nums, int length, int start, int end) {
            if (nums == null || length == 0 || end - start == 0)
                return -1;

            int small = start - 1;      //小于key的部分的最后元素位置
            int index = new Random().nextInt(end - start) + start;
            swap(nums, index, end);
            for (index = start; index < end; index++) {  //small index 类似双指针
                if (nums[index] < nums[end]) {
                    small++;
                    if (small != index) {
                        swap(nums, index, small);
                    }
                }
            }
            ++small;        //指向key， 每一次partition key都处于最终排序位置上
            swap(nums, small, end);
            return small;
        }

        public void quickSort(int[] nums, int length, int start, int end) {
            if (start == end)
                return;     // 递归推出的条件！！  重要
            int index = partition(nums, length, start, end);

            if (index > start)
                quickSort(nums, length, start, index - 1);
            if (index < end)
                quickSort(nums, length, index + 1, end);
        }

    }


    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] nums = {10, 3 , 3, 4, 5, 22, 11, 1, 2};

        System.out.println(Arrays.toString(nums));
//        sort.selection(nums);
//        sort.bubbleSort1(nums);
//        sort.insertSort(nums);
//        sort.shellSort(nums);
//        new QuickSort().quickSort(nums, nums.length, 0, nums.length-1);
//        sort.mergeSort(nums, 0, nums.length-1);
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
//        int a[] = { 51, 46};

        sort.mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));

//        System.out.println(Arrays.toString(nums));

    }

}

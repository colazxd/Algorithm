package algorithm;

public class RotatedArray {

    /**
     * 有序数组进行旋转，输出最小值
     * @param arr
     * @param length
     * @return
     */
    private int minInOrder(int[] arr, int index1, int index2) {
        int min = arr[index1];
        for (int i = index1+1; i <= index2; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public int min(int[] arr ,int length) throws Exception {
        if (arr == null || length <= 0)
            throw new Exception("invalid parameters");
        int large = 0, small = length-1;
        while(small - large > 1) {
            int mid = large + (small - large)/2;
            if (arr[large] == arr[small] && arr[mid] == arr[large])
                return minInOrder(arr, large, small);
            else {
                if (arr[mid] >= arr[large]) {
                    large = mid;
                } else if (arr[mid] <= arr[small]) {
                    small = mid;
                }

            }

        }
        return arr[small];
    }

    public static final int[] arr = {3, 4 , 5, 2, 2};

    public static final int[] arr1 = {1, 0 , 1, 1, 1};      //特殊用例， arr[mid]==arr[small]==arr[large]此时无法确定mid属于左部还是右部分

    public static void main(String[] args) {
        try {
            int small = new RotatedArray().min(arr, arr.length);
            System.out.println(small);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package algorithm.base;

public class BinarySearch<T extends Comparable<T>>{

    public int binarySearch(T[] arr, int length, T target) {
        int l = 0, r = length-1;        //在区间[l...r]中找
        while(l <= r) {                 //l=r 区间[l...r]仍然有效
            int mid = (l+r)/2;
            if (arr[mid].compareTo(target) == 0)
                return mid;
            if (arr[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}

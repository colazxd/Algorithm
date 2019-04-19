package offer;

public class Find2DArray {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length-1;
        int i = 0;
        int j = cols;
        while(array[i][j] != target && i<rows && j>=0) {
            if(array[i][j] > target)
                j--;
            else
                i++;
        }
        if(array[i][j] == target)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println("1");
    }
}
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReverseInteger {

    public static void main(String[] args) {
        Solution s = new ReverseInteger().new Solution();
        int x = 1534236469;
        s.reverse(x);
        System.out.println(x);

    }

    class Solution {
        public int reverse(int x) {
//            if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE || x == 0)
//                return 0;
            boolean negative = false;
            if(x < 0) {
                x = -x;
                negative = true;
            } else {
                negative = false;
            }
            long rev = 0;
            while(x > 0) {
                int pop = x % 10;
                rev = rev * 10 + pop;
                x /= 10;
            }
            if(rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
            if(negative)
                rev = -rev;
            System.out.println(rev);
            return 0;
        }
    }


}



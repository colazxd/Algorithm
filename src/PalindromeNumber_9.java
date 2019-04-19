public class PalindromeNumber_9 {
    class Solution {
        public boolean isPalindrome(int x) {
            short[] nums = new short[11];
            if (x < 0)
                return false;

            int i = 0;
            for (; x >= 1; i++, x/=10) {
                nums[i] = (short) (x % 10);
            }
            --i;
            int j = 0;
            while (i > j) {
                if (nums[i--] != nums[j++])
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(new PalindromeNumber_9().new Solution().isPalindrome(x));
    }
}

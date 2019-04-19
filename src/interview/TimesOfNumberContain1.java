package interview;

public class TimesOfNumberContain1 {
    /**
     * 从1到n的非负整数，包含1的整数出现的次数
     */
    static class Solution {
        public static int timesOfNumberContain1(int n) {
            int times = 0;
            for (int i=1; i<=n; i++) {
                //判断i中是否包含1
                int num = i;
                while(num >= 1) {
                    int k = num % 10;
                    if(k==1) {
                        times++;
                        break;
                    }
                    num  = num/10;
                }
            }
            return times;
        }
    }

    public static void main(String[] args) {
        int times = Solution.timesOfNumberContain1(1000);
        System.out.println(times);
    }
}

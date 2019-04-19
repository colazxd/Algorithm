package top100;

import java.util.Arrays;

public class BestTimetoBuyandSellStock_121 {
    class Solution {
        private int[] table;
        public int maxProfit(int[] prices) {
            table = new int[prices.length];
            int max = -1;

            for (int i = 0; i < prices.length; i++) {
                if (i > 2 && prices[i] == prices[i-1])
                    return max;
                Arrays.fill(table,-1);
                max = Math.max(max, profit(prices, i, prices.length-1));
            }
            return max;
        }

        private int profit(int[] prices, int buy, int sell) {
            if (sell == buy) {
                return 0;
            }
            if (table[sell] >= 0)
                return table[sell];
            int profit =Math.max(profit(prices, buy, sell-1), prices[sell] - prices[buy]);
            table[sell] = profit;
            return profit;
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices) {
            int curMax = 0, maxSoFar = 0;
            for (int i = 1; i < prices.length; i++) {
                curMax = Math.max(curMax+=prices[i]-prices[i-1], 0);
                maxSoFar = Math.max(maxSoFar, curMax);
            }
            return maxSoFar;
        }
    }
    public static void main(String[] args) {
        int[] prices = {8,6,4,3,3,2,3,5,8,3,8,2,6};
        new BestTimetoBuyandSellStock_121().new Solution().maxProfit(prices);
    }
}

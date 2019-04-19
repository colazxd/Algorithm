package top100;

import java.util.ArrayList;
import java.util.List;

//Todo 理清滑动窗口的一般思路
public class FindAllAnagramsInString_438 {

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int[] chars = new int[256];
            // 把字符串p的每个字符统计进chars数组，也可以用HashMap
            for(char ch : p.toCharArray())
                chars[ch] += 1;
            // 滑动窗口
            int left = 0, right = 0;
            int count = p.length();
            while(right < s.length()) {
                // 右窗口一直向前滑动
                if (chars[s.charAt(right++)]-- >= 1) {
                    count--;
                }

                if (count == 0) {
                    res.add(left);
                }

                //左窗口向
                if (right - left == p.length() && chars[s.charAt(left++)]++ >= 0) {
                    count++;
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> res = new FindAllAnagramsInString_438().new Solution().findAnagrams(s, p);
        System.out.println(res);
    }
}

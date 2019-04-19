import java.util.List;

public class LongestWordinDictionarythroughDeleting_524 {


    static class Solution {

        public String findLongestWord(String s, List<String> d) {
            int longest = 0;
            String result = "";

            for (String ss : d) {
                if (is_valid(s, ss)) {
                    int len = ss.length();
                    if (len > longest) {
                        result = ss;
                        longest = len;
                    } else if (len == longest) {
                        result = ss.compareTo(result)<0 ? ss: result;   //字符串比较
                    }
                }
            }
            return result;
        }

        /**
         * 做一些优化
         * 对字典的字符串，先判断长度是否小于给定字符串，大于肯定不包含
         * @param s
         * @param d
         * @return
         */
        public String findLongestWord2(String s, List<String> d) {
            int longest = 0;
            String result = "";

            for (String ss : d) {
                if(ss.length() < s.length() && is_valid(s, ss)) {}
                if (is_valid(s, ss)) {
                    int len = ss.length();
                    if (len > longest) {
                        result = ss;
                        longest = len;
                    } else if (len == longest) {
                        result = ss.compareTo(result)<0 ? ss: result;   //字符串比较
                    }
                }
            }
            return result;
        }


        /**
         * 判断s1是否部分包含s2
         * @param s1
         * @param s2
         * @return
         */
        private boolean is_valid(String s1, String s2) {
            int i = 0, j = 0;
            while(i < s1.length() && j < s2.length()) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            //s2，遍历完说明s1部分包含s2, s2部分匹配于s1
            return j>=s2.length();
        }
    }
}

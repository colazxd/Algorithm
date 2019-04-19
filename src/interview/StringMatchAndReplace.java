package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class StringMatchAndReplace {

    static class Solution {

        private static String toUpper(String s) {
            int len = s.length();
            char[] result = new char[len];
            for(int i=0; i<len; i++) {
                char ch = s.charAt(i);
                if ( ch >= 'a' && ch <= 'z') {
                    ch = (char)(ch - 32);
                }
                result[i] = ch;
            }
            return new String(result);
        }

        public static String matchAndReplace(String s1, String s2, String s3) {
            int len_s1 = s1.length();
            int len_s2 = s2.length();

            int i = 0, j = 0;
            List<Integer> matchIndex = new Vector<>();
            StringBuilder sb = new StringBuilder();
            while (i < len_s1) {
                if(s1.indexOf(s2, i) > 0) {
                    i= s1.indexOf(s2, i);
                    matchIndex.add(i);
                    i += len_s2;
                } else {
                    break;
                }
            }
//            matchIndex.add(len_s1);
//            System.out.println(matchIndex);
            int start = 0;
            for (Integer index: matchIndex) {
                String sub = s1.substring(start, index);
                sb.append(sub);
                sb.append(s3);
                start = index + s2.length();
            }
            System.out.println(start);
            if (start != len_s1)
                sb.append(s1.substring(start, len_s1));
            System.out.println(sb.toString());
            return sb.toString();
        }

        public static void main(String[] args) {
            String s = "andsdadsAADS..";
            String s1 = "ds";

            String a = Solution.toUpper(s);
            String b = Solution.toUpper(s1);
            String replace = new String("aa");

//            System.out.println(c);



            System.out.println(Solution.matchAndReplace(a, b, replace));

//            System.out.println(a);




        }
    }
}

import java.util.HashSet;
import java.util.Set;

public class ValidPalindrome125 {

    static class Solution {
        public static boolean isPalindrome(String s) {
            //删除逗号和空格特殊字符
            Set<Character> uniqueChars = new HashSet<>();
            uniqueChars.add(' ');
            uniqueChars.add(',');
            uniqueChars.add('.');
            uniqueChars.add(':');

            int i = 0, j = s.length() - 1;
            while (i < j) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                // while(uniqueChars.contains(ci)) {
                //     ci = s.charAt(++i);
                // }
                // while(uniqueChars.contains(cj)) {
                //     cj = s.charAt(--j);
                // }

                if (uniqueChars.contains(ci)) {
                    ++i;
                    continue;
                }

                if (uniqueChars.contains(cj)) {
                    --j;
                    continue;
                }



                if (ci == cj || ci == cj-'A'+ 32 || cj == ci-'A' + 32) {  //A-Z 65-90   //a-z 97-122
                    i++;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= j)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s = "OP";

        boolean aa = Solution.isPalindrome(s);
        System.out.println(aa);
    }
}

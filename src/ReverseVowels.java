import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转字符串里面的元音字母
 */
public class ReverseVowels {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        char[] result = new char[s.length()];
        while (i < j) {
            if (!vowels.contains(s.charAt(i))) {
                result[i] = s.charAt(i);
                i++;
            } else if (!vowels.contains(s.charAt(j))) {
                result[j] = s.charAt(j);
                j--;
            }else {
                result[i] = s.charAt(j);
                result[j] = s.charAt(i);
                i++;
                j--;
            }
        }
        return result.toString();
    }


}

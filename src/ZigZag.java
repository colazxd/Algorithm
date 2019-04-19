import java.util.*;

public class ZigZag {

    public static void main(String[] args) {
        Solution solution = new Solution();

        String ss = "PAYPALISHIRING";
        int numRows = 3;
        solution.convert(ss, numRows);
    }

}


class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        StringBuilder out = new StringBuilder();
        int curRow = 0;
        boolean down = false;
        for(char ch : s.toCharArray()) {
           rows.get(curRow).append(ch);
           if(curRow == 0 || curRow == numRows-1) down = !down;
           curRow += down ? 1: -1;
        }
        for (StringBuilder row: rows)
            out.append(row);
        System.out.println(out);
        return new String(out);

    }
}
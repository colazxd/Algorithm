package mircrosoft;

import java.util.*;

public class Line {

    public int find(int input1, int input2, int[][] input3) throws Exception {

        LinkedList<Integer> queue = new LinkedList<>();
        if(input1 <= 0)
            return 0;

        for (int i=1; i<=input1; i++)
            queue.add(i);

        int res = 0;
        for (int j=0; j<input2; j++) {
             switch (input3[j][0]) {
                 case 1: queue.remove(0); break;
                 case 2: queue.remove(getPos(queue, input3[j][1])); break;
                 case 3: res += getPos(queue, input3[j][1]); break;
                 default: throw new Exception("invalid query!");
             }
        }
        return res;
    }

    private int getPos(List<Integer> queue, int x) {
        int i = 0;
        while(queue.get(i) != x) {
            i++;
        }
        return i+1;
    }

    public static void main(String[] args) throws Exception {
//        int input1 = 5;
//        int input2 = 1;
//        int[][] input3 = new int[][]{{1, 0}};

        int input1 = 5;
        int input2 = 3;
        int[][] input3 = new int[][]{{1, 0}, {3, 3}, {2, 2}};
        System.out.println(Arrays.toString(input3[0]));
        int res = new Line().find(input1, input2, input3);
        System.out.println(res);
    }
}

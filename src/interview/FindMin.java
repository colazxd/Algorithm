package interview;

import java.util.List;
import java.util.ArrayList;

public class FindMin {

    public List<Integer> getMin(List<List<Integer>> arrays) {
        int topMin = 10;
        int num_list = arrays.size();
        List<Integer> union_array = new ArrayList<>();
        union_array = arrays.get(0);
        for(int i=1; i<num_list; i++) {
            //合并union_array和arrays[i]
            int m=0, n=0, total=0;
            List<Integer> candiate = arrays.get(i);
            while(m<union_array.size() && n<candiate.size() && total<topMin) {
                if (union_array.get(m) <= candiate.get(n)) {
                    m++;
                } else {

                    n++;
                }
                total++;
            }

            if (total >= topMin) {

            }
        }

    return null;
    }
}

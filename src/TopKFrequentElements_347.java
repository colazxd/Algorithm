import java.util.HashMap;
import java.util.Iterator;

public class TopKFrequentElements_347 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(5, 0);
        hashMap.put(5, hashMap.get(5)+1);
        hashMap.put(5, hashMap.get(5)+1);


        System.out.println(hashMap);
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while(iterator.hasNext()) {
            int key = iterator.next();
            int val = hashMap.get(key);
            System.out.println(key);
            System.out.println(val);
        }
    }
}

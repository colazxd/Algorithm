package algorithm;

public class Recursive {

    public int addFrom1ToN(int n) {
        if (n <= 0)
            return 0;
        else {
            return  n + addFrom1ToN(n-1);
        }


//        return n <=0 ? 0 : n + addFrom1ToN(n-1);
    }

    public static void main(String[] args) {
        int out = new Recursive().addFrom1ToN(3);
        System.out.println(out);
    }
}

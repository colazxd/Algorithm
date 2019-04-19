package interview;

public class increasment {

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 3};

        int i = 3;
        int s1, s2, s3 = 0;

        s1 = (i++) + (i++) + (i++);
        System.out.println(i);
        i = 3;

        s2 = (++i) + (++i) + (++i);

        for (i = 0;i < 10;i ++)
        {
            s3 = s3 ++;
        }
        System.out.println("s1=" + s1);

        System.out.println("s2=" + s2);

        System.out.println("s3=" + s3);

    }


}


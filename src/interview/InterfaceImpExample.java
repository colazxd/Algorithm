package interview;

public class InterfaceImpExample implements InterfaceExample{

    public static void main(String args[]) {
        new InterfaceImpExample().func1();
    }

    @Override
    public void func1() {
        System.out.println(InterfaceExample.a);
    }
}

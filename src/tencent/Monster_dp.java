package tencent;

public class Monster_dp {

    private int[] power;

    public int minMoney(int N, int[] force, int[] money) {

        power = new int[N];

        return minHelp(force, money, N-1);
    }

    //打到第i个怪兽需要的最少钱数
    private int minHelp(int[] force, int[] money, int i) {

        if(i == 0) {
            power[i] = force[i];
            return money[0];
        }
        //
        int beforeMin = minHelp(force, money, i-1);
        int need = beforeMin;

        if (power[i-1] < force[i]) { //
            
            need = beforeMin + money[i];
            power[i] = power[i-1] + force[i];
        } else {
            power[i] = power[i-1];
        }
        System.out.printf("before: power %d， money %d, face %d, cur: power %d, money %d \n", power[i-1], beforeMin, force[i], power[i], need);
        return need;
    }

    public static void main(String[] args) {
        int N = 3;
        int[] force = {8, 5, 10};
        int[] money = {1, 1, 2};
//        int N = 4;
//        int[] force = {1, 2, 4, 8};
//        int[] money = {1, 2, 1, 2};
        int m = new Monster_dp().minMoney(N, force,  money);
        System.out.println(m);

    }
}

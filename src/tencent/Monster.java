package tencent;

import java.util.PriorityQueue;

public class Monster {


    public int minMoney(int N, int[] force, int[] money) {

        int curMoney = money[0];
        int cutForce = force[0];

        PriorityQueue<Integer>  queue = new PriorityQueue<>();
        int i = 1;
        while (i < N) {
            if (cutForce >= force[i] && money[i] == 1) {    //维护能力最大的1块钱的怪兽
                queue.add(force[i]);
            } else {
                //打不过，取战斗力最大的看能不能打得过
                if (!queue.isEmpty()) {
                    int maxF1 = queue.remove();

                    if((maxF1 + cutForce) >= force[i]) {
                        cutForce += maxF1;
                        curMoney++;
                    } else if (!queue.isEmpty() && (maxF1 + queue.peek() > force[i])) {       //取两只的能力和当前怪兽能力比较，取大的
                        cutForce += queue.remove();
                        curMoney++;
                    } else {    //两只打不过 或者队列空了
                        //把取出来的第一只放回
                        queue.add(maxF1);
                    }
                } else {
                    cutForce += force[i];
                    curMoney += money[i];
                }
            }
            i++;

        }
        return curMoney;
    }

    public static void main(String[] args) {
        int N = 4;
//        int[] force = {8, 5, 10};
//        int[] money = {1, 1, 2};

        int[] force = {1, 2, 4, 8};
        int[] money = {1, 2, 1, 2};
        int m = new Monster().minMoney(N, force,  money);
        System.out.println(m);

    }
}

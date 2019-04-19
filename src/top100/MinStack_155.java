package top100;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

public class MinStack_155 {
    // 能在常数时间里返回最小值的栈
    class MinStack {

        /** initialize your data structure here. */
        PriorityQueue<Integer> pq;
        Vector<Integer> data;
        public MinStack() {
             pq = new PriorityQueue<>();
             data = new Vector<>();
        }

        public void push(int x) {
            pq.offer(x);
            data.add(x);
        }

        public void pop() {
            if (data.size() == 0)
                return;
            pq.remove(data.get(0));
            data.remove(0);
        }

        public int top() {
            return data.get(0);
        }

        public int getMin() {
            int a = pq.poll();
            System.out.println(a);
            return a;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}

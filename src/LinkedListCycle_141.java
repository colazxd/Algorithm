import java.util.HashSet;
public class LinkedListCycle_141 {
/**
 * Definition for singly-linked list.
**/
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
     }

    public static class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null)
                return false;
            HashSet<ListNode> mylist = new HashSet<>();
            while(head.next != null && !mylist.contains(head.next)) {
                mylist.add(head);
                head = head.next;
            }

            if(head.next == null)
                return false;
            else
                return true;
        }
    }

    public static void main(String[] args) {

    }
}

package top100;

import util.ListNode;

import java.util.List;

public class RemoveNthNodeFromEndofList {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;

            ListNode fast = dummyHead;      //指向待删除的前一个节点
            ListNode slow = dummyHead;


            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }
            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            ListNode del = slow.next;
            slow.next = del.next;
            return dummyHead.next;
        }
    }
}

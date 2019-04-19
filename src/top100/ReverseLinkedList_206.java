package top100;

import util.ListDataLoader;
import util.ListNode;

public class ReverseLinkedList_206 {

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode pre = head;
            ListNode cur = pre.next;
            while (cur.next != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            cur.next = pre;
            head.next = null;
            return cur;
        }
    }

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            return null;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1};
        ListNode listNode = ListDataLoader.arrayToList(nums);
        ListNode listNode1 = new ReverseLinkedList_206().new Solution().reverseList(listNode);
        System.out.println(ListDataLoader.prinList(listNode1));

    }
}

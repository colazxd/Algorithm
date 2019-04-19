package linkedList;

import util.ListNode;

public class PalindromeLinkedList_234 {

    /**
     * 判断链表是不是回文链表
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;

            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }


            return false;
        }
    }
}

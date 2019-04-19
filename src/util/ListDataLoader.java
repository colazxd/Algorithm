package util;


public class ListDataLoader {

    public static ListNode arrayToList(int[] values) {
        if (values.length == 0)
            return null;
        ListNode head =  new ListNode(values[0]);
        ListNode pre = head;
        for(int i = 1; i < values.length; i++) {
            ListNode p =  new ListNode(values[i]);
            pre.next = p;
            pre = p;
        }
        return head;
    }

    public static String prinList(ListNode head) {
        if (head == null)
            return "";
        StringBuilder res = new StringBuilder();
        while (head != null) {
            res.append(head.toString());
            head = head.next;
        }
        return res.toString();
    }


}

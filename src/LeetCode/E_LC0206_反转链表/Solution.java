package LeetCode.E_LC0206_反转链表;

import LeetCode.DataStructural.ListNode;

public class Solution {
    //递归做法
    public ListNode reverseList(ListNode head) {
        //找到链表的最后一个节点 a->b->c->null
        if(head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}

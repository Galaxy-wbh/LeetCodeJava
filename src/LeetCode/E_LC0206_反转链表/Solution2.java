package LeetCode.E_LC0206_反转链表;

import LeetCode.DataStructural.ListNode;

public class Solution2 {
    //非递归做法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        ListNode p = new Solution2().reverseList(l1);
        while(p!=null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}

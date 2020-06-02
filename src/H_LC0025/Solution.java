package H_LC0025;

import DataStructural.ListNode;

import java.util.PriorityQueue;

public class Solution {
    //把链表按长度k拆分，单独拆出来(需要该group前后设置为null)reverse后，再安装回去
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
            return null;
        int len = 0;
        ListNode p = head;
        //统计链表长度
        while(p!=null){
            len++;
            p = p.next;
        }
        int groupNum = len/k;//统计多少个分组
        int reversedGoupNum = 0;
        ListNode pre = new ListNode(-1);//哨兵节点
        ListNode res = pre;
        pre.next = head;
        ListNode groupEnd = skip(pre, k);//获取当前分组中的最后一个节点
        while(reversedGoupNum < groupNum){
            ListNode groupHead = pre.next;
            ListNode nextGroupHead = groupEnd.next;//需要拿到下一个分组的头节点
            //前后设置为null，为后面的group链表reverse作准备
            pre.next = null;
            groupEnd.next = null;
            ListNode newGroupHead = reverseList(groupHead);
            ListNode newGroupEnd = skip(newGroupHead, k-1);//获取reverse后的group尾节点
            //把reverse后的group链表重新连接起来
            pre.next = newGroupHead;
            newGroupEnd.next = nextGroupHead;
            pre = skip(pre, k);//更新pre
            groupEnd = skip(newGroupEnd, k);//更新groupEnd
            reversedGoupNum++;
        }
        return res.next;

    }

    public ListNode skip(ListNode head, int k){
        ListNode p = head;
        while(p != null && k>0){
            p = p.next;
            k--;
        }
        return p;
    }

    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
        ListNode res = new Solution().reverseKGroup(head, 2);
        System.out.println(res);
    }
}

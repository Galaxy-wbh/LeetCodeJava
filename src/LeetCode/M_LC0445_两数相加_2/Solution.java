package LeetCode.M_LC0445_两数相加_2;


import LeetCode.DataStructural.ListNode;

import java.util.Stack;

class Solution {

    //思路:把链表中的值存到栈中，pop出来计算构造新链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = new ListNode(-1);//哨兵
        res.next = null;
        ListNode p = res;
        int up = 0;
        int sum;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            sum = stack1.pop() + stack2.pop() + up;
            up = sum/10;
            ListNode node = new ListNode(sum%10);
            node.next = p.next;
            p.next = node;
        }
        while(!stack1.isEmpty()){
            sum = stack1.pop() + up;
            up = sum /10;
            ListNode node = new ListNode(sum%10);
            node.next = p.next;
            p.next = node;
        }
        while(!stack2.isEmpty()){
            sum = stack2.pop() + up;
            up = sum /10;
            ListNode node = new ListNode(sum%10);
            node.next = p.next;
            p.next = node;
        }
        if(up != 0){
            ListNode node = new ListNode(up);
            node.next = p.next;
            p.next = node;
        }

        return res.next;
    }




}

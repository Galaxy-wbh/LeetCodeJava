package LeetCode.M_LC0725_分隔链表;

import LeetCode.DataStructural.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        while(cur != null){
            N++;
            cur = cur.next;
        }
        int mod = N%k;
        int size = N/k;
        ListNode[] res = new ListNode[k];
        cur = root;
        for(int i=0;cur != null && i<k;i++){
            res[i] = cur;
            int curSize = size + (mod-- > 0?1:0);
            for(int j=0;j<curSize-1;j++){
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return res;

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        ListNode p = new ListNode(5);
        root.next.next.next.next = p;
        p.next = new ListNode(6);
        p.next.next = new ListNode(7);
        p.next.next.next = new ListNode(8);
        p.next.next.next.next = new ListNode(9);
        p.next.next.next.next.next = new ListNode(10);
    }
}

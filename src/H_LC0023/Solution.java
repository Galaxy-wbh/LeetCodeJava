package H_LC0023;

import DataStructural.ListNode;

import java.util.List;

public class Solution {
    //分治
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null || lists.length == 0)
            return null;
        int k = lists.length;
        if(k == 1)
            return lists[0];


        return merge(lists, 0, k-1);
    }

    public ListNode merge(ListNode[] lists, int left, int right){
        if(left == right)
            return lists[left];
        int mid = left + (right-left)/2;
        ListNode leftLists = merge(lists, left, mid);
        ListNode rightLists = merge(lists, mid+1, right);
        ListNode res = mergeLeftAndRight(leftLists, rightLists);
        return res;
    }

    public ListNode mergeLeftAndRight(ListNode left, ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
        ListNode p1=left, p2 = right;
        ListNode res = new ListNode(-1);
        ListNode p3 = res;
        while(p1!=null && p2!=null){
            if(p1.val < p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else{
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;

        }
        while(p1!=null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }
        while(p2!=null){
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return res.next;
    }



}

package LeetCode.M_LC0114_二叉树展开为链表;

import LeetCode.DataStructural.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void flatten(TreeNode root) {
        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }
    }


}

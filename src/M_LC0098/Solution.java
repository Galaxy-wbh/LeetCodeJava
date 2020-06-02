package M_LC0098;

import DataStructural.TreeNode;

public class Solution {
    //中序遍历
    long cur = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean left = isValidBST(root.left);
        if(cur >= root.val) return false;
        cur = root.val;
        boolean right = isValidBST(root.right);
        return  left && right;
    }
}

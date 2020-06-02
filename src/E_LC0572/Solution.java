package E_LC0572;

import DataStructural.TreeNode;

public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean res = false;
        if(s != null && t != null){
            if(s.val == t.val){
                res = hasSubTree(s,t);
            }
            if(!res)
                res = isSubtree(s.left, t);
            if(!res)
                res = isSubtree(s.right, t);
        }
        return res;
    }

    public boolean hasSubTree(TreeNode s, TreeNode t){
        if(t == null && s ==null)
            return true;
        if(t == null && s!=null)
            return false;
        if(s == null )
            return false;
        if(s.val != t.val)
            return false;
        return hasSubTree(s.left, t.left) && hasSubTree(s.right, t.right);
    }

}

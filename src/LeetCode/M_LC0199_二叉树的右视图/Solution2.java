package LeetCode.M_LC0199_二叉树的右视图;

import LeetCode.DataStructural.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    //根右左的顺序遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        dfs(root, res, 0);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> res, int depth){
        if(root == null)
            return;
        if(res.size() == depth)
            res.add(root.val);
        if(root.right != null)
            dfs(root.right, res, depth+1);
        if(root.left != null)
            dfs(root.left, res, depth+1);
    }

}

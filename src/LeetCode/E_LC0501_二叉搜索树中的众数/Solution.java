package LeetCode.E_LC0501_二叉搜索树中的众数;

import LeetCode.DataStructural.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int curCnt = 1;
    private int maxCnt = 1;
    private TreeNode preNode = null;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        int[] ans = new int[res.size()];
        for(int i=0;i<res.size();i++)
            ans[i] = res.get(i);
        return ans;
    }
    public void traverse(TreeNode root, List<Integer> res){
        if(root == null) return;
        traverse(root.left, res);
        if(preNode != null){
            if(root.val == preNode.val)  curCnt++;
            else curCnt = 1;
        }
        if(curCnt > maxCnt){
            maxCnt = curCnt;
            res.clear();
            res.add(root.val);
        }else if(curCnt == maxCnt)
            res.add(root.val);
        preNode = root;
        traverse(root.right, res);
    }
}
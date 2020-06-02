package M_LC0105;

import DataStructural.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int startPreIndex, int endPreIndex, int[] inorder, int startMiddleIndex, int endMiddleIndex){
        if(startPreIndex > endPreIndex)
            return null;
        int rootValue = preorder[startPreIndex];
        TreeNode root = new TreeNode(rootValue);
        int rootValueIndex = map.get(rootValue);
        root.left = buildTree(preorder, startPreIndex+1, rootValueIndex - startMiddleIndex + startPreIndex, inorder, startMiddleIndex, rootValueIndex-1);
        root.right = buildTree(preorder, rootValueIndex - startMiddleIndex + startPreIndex+1, endPreIndex,inorder, rootValueIndex+1, endMiddleIndex);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        System.out.println(new Solution().buildTree(pre, in));
    }
}

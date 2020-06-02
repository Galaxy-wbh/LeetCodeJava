package M_LC0199;

import DataStructural.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    //层序遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.pop();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if(i == size-1){
                    res.add(node.val);
                }
            }

        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(new Solution().rightSideView(root));
    }
}

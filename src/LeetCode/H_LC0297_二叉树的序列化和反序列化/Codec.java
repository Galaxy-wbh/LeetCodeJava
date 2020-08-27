package LeetCode.H_LC0297_二叉树的序列化和反序列化;

import LeetCode.DataStructural.TreeNode;

import java.util.*;

public class Codec {
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            sb.append("None,");
        } else{
            sb.append(root.val+",");
            serialize(root.left);
            serialize(root.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize(List<String> list){
        if(list.get(0).equals("None")) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] elements = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(elements));
        return deserialize(list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Codec().serialize(root));
    }
}
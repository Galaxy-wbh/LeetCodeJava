package DemoRecord.AlgorithmRecord.Tree;

import LeetCode.DataStructural.TreeNode;

import java.util.*;

public class TraverseTree {
    /**
     * 递归前序
     * @param root
     * @param res
     */
    public static void preOrderRecursion(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        preOrderRecursion(root.left, res);
        preOrderRecursion(root.right, res);
    }

    /**
     * //递归中序
     * @param root
     * @param res
     */
    public static void inOrderRecursion(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        inOrderRecursion(root.left, res);
        res.add(root.val);
        inOrderRecursion(root.right, res);
    }

    /**
     * 递归后序
     * @param root
     * @param res
     */
    public static void postOrderRecursion(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        postOrderRecursion(root.left, res);
        postOrderRecursion(root.right, res);
        res.add(root.val);
    }

    /**
     * 非递归前序遍历
     * 模拟递归的过程，将左子树点不断的压入栈，直到null，然后处理栈顶节点的右子树
     * @param root
     * @return
     */
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> stack=new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    /**
     * 非递归中序遍历
     * 跟非递归前序思路相似，只不过是先入栈再添加数据
     * @param root
     * @return
     */
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }

    /**
     * 非递归后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root == null)
            return res;
        stack.push(root);
        TreeNode cur, pre= null;
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(cur.left == null && cur.right == null
                    || (pre != null && (cur.left == pre || cur.right == pre))){
                TreeNode temp = stack.pop();
                res.add(temp.val);
                pre =temp;
            }else{
                if(cur.right != null)
                    stack.push(cur.right);
                if(cur.left != null)
                    stack.push(cur.left);
            }
        }
        return res;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public static List<Integer> levelTraverse(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> r1 = new ArrayList<>();
        postOrderRecursion(root, r1);
        System.out.println(r1);
        List<Integer> res = postOrderTraversal(root);
        System.out.println(res);
        System.out.println(levelTraverse(root));
    }
}

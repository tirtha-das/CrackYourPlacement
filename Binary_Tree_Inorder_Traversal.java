import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<>();
        if(root==null)  return list;
        TreeNode curr = root;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || curr!=null){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
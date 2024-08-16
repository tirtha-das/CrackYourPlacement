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
 
class BSTIterator {
    Stack<TreeNode> s1 = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode curr = s1.pop();
        pushAll(curr.right);
        return curr.val;
    }
    
    public boolean hasNext() {
        return !s1.isEmpty();
    }
    public void pushAll(TreeNode root){
        while(root != null){
            s1.push(root);
            root = root.left;
        }
    }
}


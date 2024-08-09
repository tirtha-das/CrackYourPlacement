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
      public boolean isIdentical(TreeNode root, TreeNode subRoot){
           if(root == null && subRoot == null){
               return true;
           }else if(subRoot == null || root == null){
               return false;
           }else if(subRoot.val != root.val){
               return false;
           }else if(!isIdentical(root.left, subRoot.left)){
               return false;
           }
           else if(!isIdentical(root.right, subRoot.right)){
               return false;
           }
           return true;
       }
       public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
           TreeNode curr = q.poll();
            if (curr.left != null)
             q.add(curr.left);
    
            if (curr.right != null)
             q.add(curr.right);
    
           if(curr.val == subRoot.val){
               if(isIdentical(curr, subRoot)){
                   return true;
               }
           }
       }
       return false;
       }
   }
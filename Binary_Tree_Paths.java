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
       public List<String> binaryTreePaths(TreeNode root) {
           List<String> list = new ArrayList<>();
           if(root != null)    path(root,"",list);
           return list;
       }
       private void path(TreeNode root, String pth, List<String> list){
           if(root.left == null && root.right == null)     list.add(pth+root.val);
           if(root.left != null)   path(root.left, pth+root.val+"->", list);
           if(root.right != null)   path(root.right, pth+root.val+"->", list);
       }
   }
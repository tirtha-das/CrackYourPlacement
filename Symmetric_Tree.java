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
       public boolean isSymmetric(TreeNode root) {
          
           return check(root.left,root.right);
   
       }
       public boolean check(TreeNode a,TreeNode b)
       {
           if(a==null&&b==null)
             return true;
           if(a==null||b==null||a.val!=b.val)
              return false;
           return check(a.left, b.right) && check(a.right, b.left);
       }
   }
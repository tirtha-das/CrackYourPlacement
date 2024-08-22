class TreeNode {
        int val;
         TreeNode left;
         TreeNode right;
 }


   class Solution {
   int maxSum = Integer.MIN_VALUE;
      int dfs(TreeNode root){
       
       if(root == null){
           return 0;
       }
       int left = dfs(root.left);
       int right = dfs(root.right);
       int ret = Math.max(root.val + Math.max(left,right),root.val);
       int ans = Math.max(ret,left+right+root.val);
       maxSum = Math.max(ans,maxSum); 
       return ret;     
      }
   
       public int maxPathSum(TreeNode root) {
         dfs(root);
       return maxSum;
       }
   
   
   }
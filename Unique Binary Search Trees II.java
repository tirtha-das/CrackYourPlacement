 import java.util.*;
 
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
 }
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return backtrack(1, n);
    }

     List<TreeNode> backtrack(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if(start > end) {
            list.add(null);
            return list;
        }
        for(int i=start; i<=end; i++) {
            List<TreeNode> leftNodes = backtrack(start, i - 1);
            List<TreeNode> rightNodes = backtrack(i + 1, end);

            for(TreeNode l : leftNodes) {
                for(TreeNode r : rightNodes) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = l;
                    curr.right = r;
                    list.add(curr);
                }
            }
        }
        return list;
    }
}
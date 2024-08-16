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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queuePos = new LinkedList<>();
        int ans = 0;
        queue.add(root);
        queue.add(null);
        queuePos.add(1);
        queuePos.add(0);
        int start = 1;
        int end = -1;
        int prev = -1;
        while(queue.size()!=1){
            TreeNode curr = queue.remove();
            int currPos = queuePos.remove();
            if(curr!=null){
                if(curr.left!=null){
                    queue.add(curr.left);
                    queuePos.add((2*currPos)-1);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                    queuePos.add(2*currPos);
                }
                prev = currPos;
            }else{
                end = prev;
                int width = end-start+1;
                ans = Math.max(ans,width);
                start = queuePos.peek();
                queue.add(null);
                queuePos.add(0);
            }
        }
        end = prev;
        int width = end-start+1;
        ans = Math.max(ans,width);
        return ans;
    }
}
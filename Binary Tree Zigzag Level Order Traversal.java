import java.util.*;
 
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
 }
 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, ans);
        return ans;
    }
    
     void levelOrder(TreeNode root, List<List<Integer>> ans){
        if(root == null){
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int k = 1;
        while(!stack.isEmpty()){
            List<Integer> innerList = new ArrayList<>();
            Stack<TreeNode> innerStack = new Stack<>();
            int size = stack.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = stack.pop();
                innerList.add(temp.val);
                if(k%2 == 1){
                    if(temp.left != null){
                        innerStack.push(temp.left);
                    }
                
                    if(temp.right != null){
                        innerStack.push(temp.right);
                    }
                }
                else{
                    if(temp.right != null){
                        innerStack.push(temp.right);
                    }
                    
                    if(temp.left != null){
                        innerStack.push(temp.left);
                    }
                }
            }
            stack = innerStack;
            ans.add(innerList);
            k++;
        }
    }
}
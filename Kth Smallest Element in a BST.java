 import java.util.*;
 
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
 }


class Solution {
    public void inorder(TreeNode root,ArrayList<Integer> list)
    {
        if(root==null)
        {
            return ;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list.get(k-1);
    }
}
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
    List<Integer> all;
    int i=0;
     public void Inorder(TreeNode root)
     {       
         if(root==null)
             return;
         
         Stack<TreeNode> st= new Stack<>();
         st.push(root);
         while(!st.isEmpty())
         {
             while(root.left!=null)
             {
                 st.push(root.left);
                 root=root.left;
             }
             TreeNode temp=st.pop();
             all.add(temp.val);
             if(temp.right!=null)
             {
                 root=temp.right;
                 st.push(root);
             }
         }
     }
     public BSTIterator(TreeNode root) {
         all= new ArrayList<>();
         Inorder(root);
     }
     
     public int next() {
         return all.get(i++);
     }
     
     public boolean hasNext() {
         if(i==all.size())
             return false;
         return true;
     }
 }
 

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
    public int getMinimumDifference(TreeNode root) {
       Queue<TreeNode> q=new LinkedList<>();
       List<Integer> list=new LinkedList<>();

       q.add(root);
       int index=0;
       int length=0;
       while(!q.isEmpty())
       {  
          TreeNode a=q.poll();
          list.add(a.val);
          length++;
          if(a.left!=null)
          {
               q.add(a.left);
          }
           if(a.right!=null)
           {
               q.add(a.right);
           }
          
       }
       int array[] = new int[length];
      
       for(int a:list)
       {
        array[index++]=a;
       }
       Arrays.sort(array);
       int min=Integer.MAX_VALUE;
       for(int i=1;i<array.length;i++)
       {
        min=Math.min(min,Math.abs(array[i]-array[i-1]));
       }
       return min;
    }
    
}
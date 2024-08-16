import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
}

class Tree
{  

   public static float findMedian(Node root)
    {ArrayList<Integer> list =new ArrayList<>();
        inorder(root,list);
  
     
      if(list.size()%2==0){
           int mid1=list.get(list.size()/2);
           int mid2=list.get((list.size()/2)-1);
           
          return (float)(mid1+mid2)/2;

       }return (float)list.get((list.size()-1)/2);
       
    }
    
     public static void inorder(Node root,ArrayList<Integer> list){
       
       if(root==null){
           return;
       }
       inorder(root.left,list);
       list.add(root.data);
       inorder(root.right,list);
   }
   

}
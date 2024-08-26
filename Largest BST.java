class Node  
 { 
     int data; 
     Node left, right; 
   
     public Node(int d)  
     { 
         data = d; 
         left = right = null; 
     } 
 }


class Solution{
    static class Pair
    {
        int s,mx,mn;
        Pair(int s,int mx,int mn)
        {
            this.s=s;
            this.mx=mx;
            this.mn=mn;
        }
    }
    
    static int largestBst(Node root)
    {
        // Write your code here
        
        return post(root).s;
    }
    
    static Pair post(Node root)
    {
        if(root==null)
            return new Pair(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        Pair l=post(root.left);
        Pair r=post(root.right);
        if(l.mx<root.data && r.mn>root.data)
            return new Pair(l.s+r.s+1,Math.max(root.data,r.mx),Math.min(root.data,l.mn));
        else
            return new Pair(Math.max(l.s,r.s),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
}
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
 
 

class Solution{
    
    int idx = 0;
    
    Node constructTree(int n, int pre[], char preLN[]){
	    if(idx==n) return null;
        
        Node cur = new Node(pre[idx]);
        idx++;
        
        if(preLN[idx-1]=='N'){
           
                cur.left = constructTree(n,pre,preLN);
           
                cur.right = constructTree(n,pre,preLN);
            
        }
        
        return cur;
	    
    }
}

 
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}


 class Solution {
    
    int idx;
    public Node Bst(int pre[], int size) {
        idx=0;
        return helper(pre,1,10000);
        
    }
    public Node helper(int pre[],int l,int r){
        if(idx>=pre.length)return null;
        if(pre[idx]<l|| pre[idx]>r)return null;
        Node node=new Node(pre[idx++]);
        node.left=helper(pre,l,node.data-1);
        node.right=helper(pre,node.data+1,r);
        return node;
    }
}
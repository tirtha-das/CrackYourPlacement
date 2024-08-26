class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}

class Solution{
    //Function to convert binary tree to doubly linked
    Node prev= null;
    Node head= null;
    
    Node bToDLL(Node root){
	    if(root==null) return root;
	    bToDLL(root.left);
	    if(prev==null){
	        head= root;
	        prev= root;
	    }else{
	        root.left= prev;
	        prev.right= root;
	        prev= root;
	    }
	    bToDLL(root.right);
	    return head;
    }
}
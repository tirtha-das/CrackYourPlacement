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


class Solution
{
    Node head,prev;
    
    Node bToDLL(Node root)
    {
	    prev = null;
	    convertDLL(root);
	    return head;
    }
    
    void convertDLL(Node root) {
        if(root == null)  return ;
        
        convertDLL(root.left);
        
        if(prev == null) {
            head = root;
        }else {
            root.left = prev;
            prev.right = root;
        }
        
        prev = root;
        
        convertDLL(root.right);
        
        return ;
    }
}
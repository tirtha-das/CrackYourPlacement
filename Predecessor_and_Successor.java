class Solution {
    
    private static Node findPred(Node root, int key) {
        Node temp = root;
        Node max = null;
        while(temp!=null) {
        if(temp.data < key) {
            max = temp;
            temp = temp.right;
         }
         else temp = temp.left;
        }
        
        return max;
        
    }
    
    private static Node findSuc(Node root, int key) {
        Node temp = root;
        Node min = null;
        while(temp!=null) {
            if(temp.data > key) {
                min = temp;
                temp = temp.left;
            }
            else temp = temp.right;
        }
        return min;
    }
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        Node max = findPred(root, key);
        Node min = findSuc(root, key);
        pre[0] = max;
        suc[0] = min;
        
    }
}
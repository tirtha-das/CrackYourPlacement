class Node {
    public int data;
    public Node left;
    public Node right;
}

class Solution{
    int getCount(Node root,int l, int h) {
        helper(root, l, h);
        return count;
    }
    int count = 0;
    void helper(Node root, int low, int high) {
        if(root != null){
            if(root.data>=low && root.data<=high) {
                count++;
            }
            if(low < root.data){
                helper(root.left, low, high);
            }
            if(root.data < high) {
                helper(root.right, low, high);
            }
        }
    }
}
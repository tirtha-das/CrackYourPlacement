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
    private class Pair{
        int height;
        boolean isBalanced;
        
        Pair(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    private Pair helper(TreeNode root) {
        if(root == null) {
            Pair newPair = new Pair(0, true);
            return newPair;
        }
        
        Pair leftPair = helper(root.left); 
        Pair rightPair = helper(root.right); 
        
        int height = Math.max(leftPair.height, rightPair.height) + 1;
        boolean isBalanced = leftPair.isBalanced && rightPair.isBalanced && (Math.abs(leftPair.height - rightPair.height) <= 1);
        Pair newPair = new Pair(height, isBalanced);
        
        return newPair;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root ==  null) {
            return true;
        }    
        
        Pair pair = helper(root);
        
        return pair.isBalanced;
    }
}
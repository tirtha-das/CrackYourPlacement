 import java.util.*;
 
 class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
 }
class Solution {
    List<Integer> list = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++){
            printCurrentLevel(root, i);
            list.add(res.get(res.size()-1));
            res = new ArrayList<>();
        }
        return list;
    }
    
    int height(TreeNode root)
    {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
 
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
 
    void printCurrentLevel(TreeNode root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            res.add(root.val);
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }
}
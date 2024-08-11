 import java.util.*;
 
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        
        if(k == 0){
            list.add(target.val);
            return list;
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        getParents(root, null, parents);

        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        set.add(target);
        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(node.left != null && !set.contains(node.left)){
                    q.offer(node.left);
                    set.add(node.left);
                }
                if(node.right != null && !set.contains(node.right)){
                    q.offer(node.right);
                    set.add(node.right);
                }
                if(parents.get(node) != null && !set.contains(parents.get(node))){
                    q.offer(parents.get(node));
                    set.add(parents.get(node));
                }
            }

            dist++;
            if(dist == k) break;
        }

        while(!q.isEmpty()){
            list.add(q.poll().val);
        }

        return list;
    }

    void getParents(TreeNode node, TreeNode prev, Map<TreeNode, TreeNode> map){
        if(node == null) return;

        map.put(node, prev);
        getParents(node.left, node, map);
        getParents(node.right, node, map);
    }
}
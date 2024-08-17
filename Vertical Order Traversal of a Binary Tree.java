 import java.util.*;
 
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
 }
class NodeDistance {
    
    int dist;
    TreeNode node;
    NodeDistance(int dist, TreeNode node) {
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<>();
        }
        
        TreeMap<Integer, List<Integer>>  distanceMap = new TreeMap<>();
        Queue<NodeDistance> q = new LinkedList<>();
        q.add(new NodeDistance(0, root));
        
        //Level order traversal
        while(!q.isEmpty()) {
            
            int size = q.size();
            HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
            while(size-- > 0) {
                
                NodeDistance current = q.poll();
                int distance = current.dist;
                List<Integer> nodeList = levelMap.getOrDefault(distance, new ArrayList<>());
                nodeList.add(current.node.val);
                Collections.sort(nodeList);
                levelMap.put(distance, new ArrayList<>(nodeList));
                
                if(current.node.left != null) {
                    q.add(new NodeDistance(distance-1, current.node.left));
                }
                
                 if(current.node.right != null) {
                    q.add(new NodeDistance(distance+1, current.node.right));
                }
                
            }
			
            //Update the distanceMap with levelMap values
            for(Map.Entry<Integer,List<Integer>> entry : levelMap.entrySet()) {
                
                List<Integer> nodeList = distanceMap.getOrDefault(entry.getKey(), new ArrayList<>());
                nodeList.addAll(entry.getValue());
                distanceMap.put(entry.getKey(), nodeList);
                
            }
        }
        
        return new ArrayList<>(distanceMap.values());
        
    }
}
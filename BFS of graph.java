import java.util.*;

class Solution {
    ArrayList<Integer>  result = new ArrayList<>();
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        q.add(0);
        
        while(q.isEmpty() == false){
            
            int currentVertex = q.poll();
            result.add(currentVertex);
            visited[currentVertex] = true;
            for(int i = 0; i<adj.get(currentVertex).size();i++){
                int nei = adj.get(currentVertex).get(i);
                if(visited[nei] == false){
                    q.add(nei);
                    visited[nei] = true;
                }
            }
        }
        return result;
    }
}
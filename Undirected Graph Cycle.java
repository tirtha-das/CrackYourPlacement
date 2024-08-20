import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int vis[])
    {
        vis[node]=1;
        for(int adjNode:adj.get(node))
        {
            if(vis[adjNode]==0)
            {
                if(dfs(adjNode,node,adj,vis))
                return true;
            }
            else if(parent!=adjNode)
            return true;
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,-1,adj,vis))
                return true;
            }
        }
        return false;
    }
}
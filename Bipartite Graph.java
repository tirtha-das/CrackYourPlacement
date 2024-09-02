import java.util.*;

class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        for(int i =0;i<V;i++) {
            color[i] = -1;
        }
        
        for(int i=0;i<V;i++) {
            if(color[i] == -1) {
                if(dfs(i,0,color,adj) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int node,int newColor,int[] color,ArrayList<ArrayList<Integer>>adj) {
        color[node] = newColor;
        for(int val:adj.get(node)) {
            if(color[val] == -1) {
                if(dfs(val,1-newColor,color,adj)== false) {
                    return false;
                }
            } else if(color[val] == newColor) {
                return false;
            }
        }
        return true;
    }
}